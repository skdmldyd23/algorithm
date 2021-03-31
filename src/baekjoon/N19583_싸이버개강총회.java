package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N19583_½ÎÀÌ¹ö°³°­ÃÑÈ¸ {

	public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextElement().toString();
		String e = st.nextElement().toString();
		String q = st.nextElement().toString();
		
		String str = "1";
		String[] strArr;
		HashMap<String, String> checkStart = new HashMap<>();
		HashMap<String, String> checkEnd = new HashMap<>();
		
		while(!"".equals(str = br.readLine())) {
			if(str == null) break;
			strArr = str.split(" ");
			if(s.compareTo(strArr[0]) >= 0) checkStart.put(strArr[1], strArr[0]);
			else if(e.compareTo(strArr[0]) <= 0 && q.compareTo(strArr[0]) >= 0) checkEnd.put(strArr[1], strArr[0]);
		}
		
		int cnt = 0;
		if(checkStart.size() != 0 && checkEnd.size() != 0) {
			for( String key : checkStart.keySet() ) {
				if(checkEnd.get(key) == null) continue;
				++cnt;
			} 			
		}
		
	   System.out.println(cnt);
   }

}