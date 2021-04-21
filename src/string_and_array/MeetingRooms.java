package string_and_array;

import java.util.Arrays;
import java.util.Comparator;

// 주어진 값이 하나의 미팅룸으로 만들어질 수 있는지
class Interval1{
	int start;
	int end;
	Interval1(){
		this.start = 0;
		this.end = 0;
	}
	Interval1(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class MeetingRooms {
	public static void main(String[] args) {
		MeetingRooms a = new MeetingRooms();
		
	
		Interval1 in1 = new Interval1(7,10);
		Interval1 in2 = new Interval1(2,4);
		Interval1 in3 = new Interval1(1,2);
		
		Interval1[] intervals = {in1, in2, in3};
		System.out.println(a.solve(intervals));
	}
	
	public boolean solve(Interval1[] intervals) {
		if(intervals == null || intervals.length == 0) return false;
		
		Arrays.sort(intervals, (Interval1 o1, Interval1 o2) -> o1.start - o2.start);
		
		for(int i = 1; i < intervals.length; ++i) {
			if(intervals[i-1].end > intervals[i].start) return false;
		}
		
		return true;
	}
}