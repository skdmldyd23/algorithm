package hash;

/*
 * ���� ����
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
 * ��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
 * 
 * ������ : 119
 * ���ؿ� : 97 674 223
 * ������ : 11 9552 4421
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���� ����
 * phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
 * �� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
 * ����� ����
 * phone_book	return
 * [119, 97674223, 1195524421]	false
 * [123,456,789]	true
 * [12,123,1235,567,88]	false
 * ����� �� ����
 * ����� �� #1
 * �տ��� ������ ���� �����ϴ�.
 * 
 * ����� �� #2
 * �� ��ȣ�� �ٸ� ��ȣ�� ���λ��� ��찡 �����Ƿ�, ���� true�Դϴ�.
 * 
 * ����� �� #3
 * ù ��° ��ȭ��ȣ, ��12���� �� ��° ��ȭ��ȣ ��123���� ���λ��Դϴ�. ���� ���� false�Դϴ�.
*/
public class hash_lv2 {
	
public static void main(String[] args) {
	String[] phone_book = {"119", "97674223", "1195524421"};
	System.out.println(solution(phone_book));
}
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(String target : phone_book) {
        	for(String target2 : phone_book) {
        		if(target.equals(target2)) continue;
        		else if(target.length() < target2.length()) continue;
        		else if(target.startsWith(target2)) return !answer;
        	}
        }
        return answer;
    }
}
