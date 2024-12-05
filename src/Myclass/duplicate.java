package Myclass;
import java.util.*;
public class duplicate {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		duplicatefind(nums);
	}
	public static void duplicatefind(int nums[]) {
		List<Integer> res=new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			int index=Math.abs(nums[i])-1;
			if(nums[index]<0) {
				res.add(nums[index]*-1);
			}
			nums[index]=nums[index]*-1;
		}
		System.out.println(res);
	}
}
