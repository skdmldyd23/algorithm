package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N18869_멀티버스2 {
	static int N, M;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextElement().toString());
		N = Integer.parseInt(st.nextElement().toString());
		
		int[][] map = new int[M][N];
		
		for(int r=0; r<M; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i=0; i<M-1; i++) {
			for(int j=i+1; j<M; j++) {
				if(!compare(map[i], map[j])) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	private static boolean compare(int[] arr1, int[] arr2) {
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr1[i] > arr1[j]) {	if(arr2[i] <= arr2[j]) return true;	}
				else if(arr1[i] < arr1[j]) { if(arr2[i] >= arr2[j]) return true; }
				else { if(arr2[i] != arr2[j]) return true; }
			}
		}
		return false;
	}
}