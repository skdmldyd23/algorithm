package hash;

import java.util.ArrayList;
import java.util.HashMap;

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
		String[] genres = {"classic","pop","classic","classic","pop"};
		int[] plays = {500,600,150,800,2500};
		
		System.out.println(solution(genres, plays));
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		String genre = "";
		int play = 0;
		HashMap<String, ArrayList<Integer>> album = new HashMap<String, ArrayList<Integer>>();
		for(int i = 0; i < genres.length; ++i){
			genre = genres[i];
			play = plays[i];
			if(album.containsKey(genre)) {
				album.get(genre).add(plays[i]);
				continue;
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(play);
				album.put(genre, temp);
			}
		}
		
		return answer;
    }
}
