package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ¼¼¿ë¾× {
	public static void main(String[] args) throws Exception {
		boolean isAllminus = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		double[] arr = new double[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > 0) isAllminus = false;
			arr[i] = num;
		}

		Arrays.sort(arr);
		
		if (isAllminus) System.out.println((int)arr[n - 3] + " " + (int)arr[n - 2] + " " + (int)arr[n - 1]);
		else {
			double[] answerArr = sol(n, arr);
			System.out.println((int)answerArr[0] +" "+ (int)answerArr[1] +" "+ (int)answerArr[2]);
		}
	}

	static double[] sol(int n, double[] arr) {
		double[] answerArr = new double[3];
		double answer = Double.MAX_VALUE;
		double tempSum;
		int j,k; 
		
		for (int i = 0; i < n; ++i) {
			j = i + 1;
			k = n - 1;
			while (j < k) {
				tempSum = arr[i] + arr[j] + arr[k];
				if(tempSum == 0) {
					answerArr[0] = arr[i];
					answerArr[1] = arr[j];
					answerArr[2] = arr[k];
					return answerArr;
				}
				if(Math.abs(tempSum) < answer) {
					answerArr[0] = arr[i];
					answerArr[1] = arr[j];
					answerArr[2] = arr[k];
					answer = Math.abs(tempSum);
				}
				if(tempSum < 0) ++j;
				else --k;
			}
		}
		return answerArr;
	}
}
