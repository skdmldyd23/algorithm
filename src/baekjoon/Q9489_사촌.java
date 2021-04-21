package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9489_사촌 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String targetStr = br.readLine();
			if(targetStr.equals("0 0")) break;
//			요소 갯수
			int n = Integer.parseInt(targetStr.split(" ")[0]);
//			타겟 요소
			int target = Integer.parseInt(targetStr.split(" ")[1]);
			int targetIndex = -1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nodeArr = new int[n];
			int i = 0;
			
//			노드배열
			while(st.hasMoreTokens()) {
				int token = Integer.parseInt(st.nextToken());
				nodeArr[i] = token;				
				if(target == token) targetIndex = i;
				++i;
			}
//			최상위면
			if(targetIndex == 0) {
				System.out.println(0);
				continue;
			}
			
//			부모배열
			int[] parents = new int[n];
			int current = -1;
			parents[0] = -1;
			for (int j = 1; j < n; ++j) {
				if (nodeArr[j] != nodeArr[j - 1] + 1)
					current++;
				parents[j] = current;
			}
			
//			사촌구하기
//			자신의 부모와 다르고, 부모의 부모가 같음
			int cousin = 0;
			for(int j = 1; j < n; ++j) {
				if(parents[j] != parents[targetIndex] && parents[parents[j]] == parents[parents[targetIndex]]) {
					++cousin;
				}
			}
			System.out.println(cousin);
		}
	}
}