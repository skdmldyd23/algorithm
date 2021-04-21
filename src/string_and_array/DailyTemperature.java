package string_and_array;

import java.util.Stack;
// nums의 요소 보다 높은 요소가 나오는 날 (ex) 75보다 높은 온도가 언제 나오는가? -> 4 없으면 0)
// 스택으로 인덱스를 저장하고, 현재값이 스택의 값보다 높으면 현재의 index - 스택 index로 저장
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
