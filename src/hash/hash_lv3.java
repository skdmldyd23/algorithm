package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 * 
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 * 
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 * 
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 */
public class hash_lv3 {
	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		System.out.println(solution(genres, plays));
	}

	public static int[] solution(String[] genres, int[] plays) {
		String genre = "";
		String play_s = "";
		int play_i = 0;
		HashMap<String, ArrayList<String>> album = new HashMap<String, ArrayList<String>>();
		HashMap<String, Integer> album_total = new HashMap<String, Integer>();
		for (int i = 0; i < genres.length; ++i) {
			genre = genres[i];
			play_s = Integer.toString(plays[i]) + "," + i;
			play_i = plays[i];
			if (album.containsKey(genre)) {
				int total = album_total.get(genre) + play_i;
				album_total.put(genre, total);
				album.get(genre).add(play_s);
				continue;
			}

			ArrayList<String> temp = new ArrayList<String>();
			temp.add(play_s);
			album.put(genre, temp);
			album_total.put(genre, play_i);
		}

		List<Entry<String, Integer>> total_entries = new ArrayList<Entry<String, Integer>>(album_total.entrySet());
		Collections.sort(total_entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
		
		List<Integer> indexList = new ArrayList<Integer>();
		for (Entry<String, Integer> total : total_entries) {
			indexList.addAll(album.get(total.getKey())
					.stream()
					.sorted((o1, o2) -> Integer.parseInt(Arrays.asList(o1.split(",")).get(0))
							> Integer.parseInt(Arrays.asList(o2.split(",")).get(0)) ? -1 : 1)
					.limit(2)
					.map(s -> Integer.parseInt(Arrays.asList(s.split(",")).get(1)))
					.collect(Collectors.toList()));
		}
		
		return indexList.stream().mapToInt(Integer::intValue).toArray();
	}
}
