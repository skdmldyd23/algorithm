package string_and_array;

import java.util.Stack;
// nums�� ��� ���� ���� ��Ұ� ������ �� (ex) 75���� ���� �µ��� ���� �����°�? -> 4 ������ 0)
// �������� �ε����� �����ϰ�, ���簪�� ������ ������ ������ ������ index - ���� index�� ����
public class DailyTemperature {

	public static void main(String[] args) {
		int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] res = dailyTemperatures(nums);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static int[] dailyTemperatures(int[] temperatures) {
		int[] ret = new int[temperatures.length];
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < temperatures.length; ++i) {
			
			while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
				int index = st.pop();
				ret[index] = i - index;
			}
			st.push(i);
		}
		return ret;
	}
}
