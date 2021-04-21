package string_and_array;

import java.util.HashSet;

// J의 각 요소가 S에 몇개가 있는가
public class JewelsAndStones {
	public static void main(String[] args) {
		String J = "aA", S = "aAAbbbb";
		JewelsAndStones j = new JewelsAndStones();
		System.out.println(j.solve(J, S));
	}
	private int solve(String jew, String stone) {
		char[] jArr = jew.toCharArray();
		int cnt = 0;
		HashSet<Character> jSet = new HashSet<Character>();
		for(char j : jArr) {
			jSet.add(j);
		}
		for(char s : stone.toCharArray()) {
			if(jSet.contains(s)) ++cnt;
		}
		return cnt;
	}
}
