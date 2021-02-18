package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
 * ���� ����
 * ��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
 * 
 * ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
 * �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
 * �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
 * �뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��, ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * ���ѻ���
 * genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
 * plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
 * genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
 * �帣 ������ 100�� �̸��Դϴ�.
 * �帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
 * ��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
 * ����� ��
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * ����� �� ����
 * classic �帣�� 1,450ȸ ����Ǿ�����, classic �뷡�� ������ �����ϴ�.
 * 
 * ���� ��ȣ 3: 800ȸ ���
 * ���� ��ȣ 0: 500ȸ ���
 * ���� ��ȣ 2: 150ȸ ���
 * pop �帣�� 3,100ȸ ����Ǿ�����, pop �뷡�� ������ �����ϴ�.
 * 
 * ���� ��ȣ 4: 2,500ȸ ���
 * ���� ��ȣ 1: 600ȸ ���
 * ���� pop �帣�� [4, 1]�� �뷡�� ����, classic �帣�� [3, 0]�� �뷡�� �״����� �����մϴ�.
 * 
 * �� ���� - 2019�� 2�� 28�� �׽�Ʈ���̽��� �߰��Ǿ����ϴ�.
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
