package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Q1_추석_트래픽 {
// 초로 구분이 아니라 
//	a라는 친구의 start부터 end 사이에 
//	b라는 친구가 시작을 하냐<<<이게 포인트 내일 ㄱ
	public static void main(String[] args) {
		String[] lines  = { 
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s" };
		System.out.println(solution(lines));
		System.out.println(String.format("%.3f", (59.4+1.3)%60));
	}
	
	public static int solution(String[] lines) {
		int answer = 0;
		String t = "";
		double start = 0;
		double end = 0;
		int cnt;
		for(int i = 0; i < lines.length; ++i) {
			cnt = 0;
			end = getTime(lines[i], true);
			
			for(int j = i; j < lines.length; ++j) {
				start = getTime(lines[j], false);
				if(start < end) ++cnt;;
				
//				j의 start가 i의 end보다 작으면 + else break;
			}
			if (answer < cnt) answer = cnt;
		}
//		String lkey = "";
//		String lValue = "";
//		String[] secArr = new String[3];
//		double end = 0;
//		double start = 0;
//		String h,m;
//		HashMap<String, Integer> timecount = new HashMap<String, Integer>();
//		String skey = "";
//		for(Entry<String, String> lineEntry : lineHash.entrySet()) {
//			lkey = lineEntry.getKey();
//			lValue = lineEntry.getValue();
//			secArr = Arrays.asList(lkey).get(0).split(":");
//			h = secArr[0];
//			m = secArr[1];
//			start = Double.parseDouble(secArr[2]);
//			end = start + Double.parseDouble(lValue.substring(0,lValue.length()-1));
//			
//			for (int i = (int)start; i < end; ++i) {
//				skey = h+m+i;
//				if(timecount.containsKey(skey)) timecount.put(skey, timecount.get(skey)+1);
//				else timecount.put(skey, 1);
//			}
//			
//		}
//		
//		answer = timecount
//					.entrySet()
//					.stream()
//					.max((o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1)
//					.get()
//					.getValue();
//		
        return answer;
	}

	public static double getTime(String t, boolean isAdded) {
		String[] lineArr = t.split(" ");
		String[] timeArr = lineArr[1].split(":");

		double ingTime = isAdded ? Double.parseDouble(lineArr[2].substring(0,lineArr[2].length()-1)) : 0;
		double h = Double.parseDouble(timeArr[0]);
		double m = Double.parseDouble(timeArr[1]);
		double s = Double.parseDouble(timeArr[2]);
		
		return h*3600+m*60+s+ingTime;
	}
}
