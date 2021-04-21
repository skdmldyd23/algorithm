package string_and_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//주어진 값으로 몇개의 미팅룸을 만들어야하는가?

class Interval2{
	int start;
	int end;
	public Interval2() {
		this.start = 0;
		this.end = 0;    
	}  
	
	public Interval2(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
}

public class MeetingRooms2 {
	public static void main(String[] args) {
		MeetingRooms2 a = new MeetingRooms2();
		
		Interval2 in1 = new Interval2(4, 9);
		Interval2 in2 = new Interval2(5, 15);
		Interval2 in3 = new Interval2(0, 30);
		Interval2 in4 = new Interval2(10, 16);
		
		Interval2[] intervals = {in1, in2, in3, in4};
		System.out.println(a.solve(intervals));
	}
	
	public int solve(Interval2[] intervals) {
		if(intervals == null || intervals.length == 0) return -1;
		
		Interval2 now;
		Arrays.sort(intervals, (Interval2 o1, Interval2 o2) -> o1.start - o2.start);
		
		Queue<Interval2> pq = new PriorityQueue<Interval2>((Interval2 o1, Interval2 o2) -> o1.end - o2.end);
		
		pq.offer(intervals[0]);
		
		for(int i = 1; i < intervals.length; ++i) {
			now = intervals[i];
			if(pq.peek().end <= now.start) pq.poll();
			pq.offer(now);
		}
		
		return pq.size();
	}
	Comparator<Interval2> comp = new Comparator<Interval2>() {
		
		@Override
		public int compare(Interval2 o1, Interval2 o2) {
			// TODO Auto-generated method stub
			return o1.start - o2.start;
		}
	};
}