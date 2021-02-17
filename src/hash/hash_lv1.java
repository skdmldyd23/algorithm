package hash;

import java.util.HashMap;

/*
 * ���� ����
 * ������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
 * 
 * �����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���ѻ���
 * ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
 * completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
 * �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
 * ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
 * ����� ��
 * participant	completion	return
 * [leo, kiki, eden]	[eden, kiki]	leo
 * [marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
 * [mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
 * ����� �� ����
 * ���� #1
 * leo�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
 * 
 * ���� #2
 * vinko�� ������ ��ܿ��� ������, ������ ��ܿ��� ���� ������ �������� ���߽��ϴ�.
 * 
 * ���� #3
 * mislav�� ������ ��ܿ��� �� ���� ������, ������ ��ܿ��� �� ��ۿ� ���� ������ �Ѹ��� �������� ���߽��ϴ�.
 */
public class hash_lv1 {

	public static void main(String[] args) {
		String[] participant = {"mislav","stanko", "mislav", "stanko"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant, completion));
	}
	
 public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> compleHash = new HashMap<String,Integer>();
        Integer a = 0;
        for(String target : completion) {
        	a = compleHash.get(target) == null ? 1 : compleHash.get(target)+1;
        	compleHash.put(target, a);
        }
        for(String answer : participant) {
        	a = compleHash.get(answer);
        	if(a == null) return answer;
        	else if(a-1 < 0) return answer;
        	compleHash.put(answer, a-1);
        }
        return null;
    }
}
