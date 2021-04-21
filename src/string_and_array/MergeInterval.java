package string_and_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// 주어진 값을 머지하기
// (1,3) (2, 6) -> (1, 6)
class Interval {
	int start;
	int end;

	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class MergeInterval {
	public static void main(String[] args) {
		Interval in1 = new Interval(1, 3);
		Interval in2 = new Interval(2, 6);
		Interval in3 = new Interval(8, 10);
		Interval in4 = new Interval(15, 18);

		List<Interval> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in3);
		intervals.add(in2);
		intervals.add(in4);
		MergeInterval mi = new MergeInterval();
		List<Interval> results = mi.merge(intervals);
		for(Interval result : results) {
			System.out.println("[" + result.start +", "+result.end+"]" );
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals,(o1,o2) -> o1.start- o2.start);
		List<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		
		for(int i = 1; i < intervals.size(); ++i) {
			Interval now = intervals.get(i);
			if(prev.end > now.start) prev.end = now.end;
			else {
				result.add(prev);
				prev = now;
			}
		}
		if(!result.contains(prev)) result.add(prev);
		return result;
	}
}
