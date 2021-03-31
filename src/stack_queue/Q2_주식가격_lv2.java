package stack_queue;

public class Q2_주식가격_lv2 {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(solution(prices));
	}

	private static int[] solution(int[] prices) {
		// TODO Auto-generated method stub
		int len = prices.length;
		int[] answer = new int[len];
		for (int i = 0; i < len; ++i) {
			for (int j = i + 1; j < len; ++j) {
            	++answer[i];
            	if (prices[i] > prices[j]) break;
            }
		}
		return answer;
	}
}