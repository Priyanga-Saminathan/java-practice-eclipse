package Myclass;
import java.util.*;
class Interval{
	int start;
	int end;
	public Interval() {
		this.start=0;
		this.end=0;
	}
	public Interval(int start,int end) {
		this.start=start;
		this.end=end;
	}
}
public class mergeInterval1 {
	public static void main(String args[]) {
		List<Interval> intervals=Arrays.asList(new Interval(1,3),new Interval(2,5),new Interval(3,7),new Interval(9,10));
		List<Interval> result=merge(intervals);
		for(Interval inter:result) {
			System.out.print("["+inter.start+","+inter.end+"]");
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals==null || intervals.size()==0) {
			return new ArrayList<>();
		}
//		intervals.sort(Comparator.comparingInt(inter->inter.start));
		Collections.sort(intervals,new Comparator<Interval>() {
			public int compare(Interval a,Interval b) {
				if(a.start==b.start) {
					return 0;
				}
				else if(a.start>b.start) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});	
		List<Interval> result=new ArrayList<>();
		Interval current=intervals.get(0);
		for(int i=1;i<intervals.size();i++) {
			Interval next=intervals.get(i);
			if(current.end>=next.start) {
				current.end=Math.max(current.end, next.end);
			}
			else {
				result.add(current);
				current=next;
			}
		}
		result.add(current);
		return result;
	}
}
