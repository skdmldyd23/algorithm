package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9489_���� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String targetStr = br.readLine();
			if(targetStr.equals("0 0")) break;
//			��� ����
			int n = Integer.parseInt(targetStr.split(" ")[0]);
//			Ÿ�� ���
			int target = Integer.parseInt(targetStr.split(" ")[1]);
			int targetIndex = -1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nodeArr = new int[n];
			int i = 0;
			
//			���迭
			while(st.hasMoreTokens()) {
				int token = Integer.parseInt(st.nextToken());
				nodeArr[i] = token;				
				if(target == token) targetIndex = i;
				++i;
			}
//			�ֻ�����
			if(targetIndex == 0) {
				System.out.println(0);
				continue;
			}
			
//			�θ�迭
			int[] parents = new int[n];
			int current = -1;
			parents[0] = -1;
			for (int j = 1; j < n; ++j) {
				if (nodeArr[j] != nodeArr[j - 1] + 1)
					current++;
				parents[j] = current;
			}
			
//			���̱��ϱ�
//			�ڽ��� �θ�� �ٸ���, �θ��� �θ� ����
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