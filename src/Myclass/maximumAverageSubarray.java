package Myclass;

public class maximumAverageSubarray {
	public static void main(String args[]) {
		int nums[]= {1,12,-5,-6,50,3};
		int k=4;
		subarray(nums,k);
	}
	public static void subarray(int nums[],int k) {
		int sum=0;
		for(int i=0;i<k;i++) {
			sum+=nums[i];
//			System.out.println(sum);
		}
		int startindex=0;
		int endindex=k;
		int avgsum=sum;
		while(endindex<nums.length) {
			sum=sum-nums[startindex];
			startindex++;
//			System.out.println("Sum is:"+sum);
			sum=sum+nums[endindex];
			endindex++;
//			System.out.println("Sum is:"+sum);
			avgsum=Math.max(sum, avgsum);
//			System.out.println(avgsum);
		}
		System.out.println((double)avgsum/k);
	}
}
