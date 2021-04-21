package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q20191_���Ӹ� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		�갡�ɶ��
		String s = br.readLine();
		
//		�긦 ����ݺ�?
		String t = br.readLine();
		char[] sArr = s.toCharArray();
		boolean isPoss = true;
		int cnt = 0;
//		�ݺ��� �迭�� s�� ���ĺ��� ���ٸ� ��
		if(s.equals(t)) {
			System.out.println(1);
			return;
		}
		for(int i = 0; i < s.length(); ++i) {
			if(!t.contains(sArr[i]+"")) {
				System.out.println(-1);
				return;
			}
		}
		
		
//		�ݺ��ϴ� ģ��
		StringBuilder str2 = new StringBuilder();
		for(int i = 0; i < s.length(); ++i) {
			StringBuilder resultStart = new StringBuilder();
			StringBuilder resultEnd = new StringBuilder();
			str2.append(t);
			if(str2.length() < s.length()) continue;
			int start = 0;
			int end = s.length()-1;
			char[] str2a = str2.toString().toCharArray();
			for(int j = 0; j < str2.length(); ++j) {
				if(sArr[start] == str2a[j]) {
					resultStart.append(sArr[start]);
					++start;
				} else if(sArr[end] == str2a[str2.length()-j-1]) {
					resultEnd.insert(0, sArr[end]);
					--end;
				}
				if((resultStart.toString()+resultEnd.toString()).equals(s)) {
					cnt = i;
					break;
				};
			}
			if(cnt != 0) break; 
		}
		System.out.println(cnt+1);
	}
}
