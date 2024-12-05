package Myclass;
import java.util.Scanner;
public class SubSequence {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String A=sc.next();
		String B=sc.next();
		char arr1[]=A.toCharArray();
		char arr2[]=B.toCharArray();
		int j=0,count=0;
		for(int i=0;i<arr2.length;i++) {
			if(j<arr1.length) {
				if(arr1[j]==arr2[i]) {
					count++;
					j++;
				}
			}
		}
		if(count==arr1.length) {
			System.out.println("subsequence");
		}
		else {
			System.out.println("Not a subsequence");
		}
	}
}
