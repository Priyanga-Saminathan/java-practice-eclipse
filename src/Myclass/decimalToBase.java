package Myclass;
import java.util.*;
public class decimalToBase {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int b=sc.nextInt();
		String str=convertToBase(n,b);
		System.out.println(str);
		sc.close();
	}
	public static String convertToBase(int n,int b) {
		if(n==0) {
			return "0";
		}
		StringBuffer sb=new StringBuffer();
		int rem;
		while(n>0) {
			rem=n%b;
//			if(rem<10) {
//				sb.append((char)('0'+rem));
//			}
//			else {
//				sb.append((char)('A'+rem-10));
//			}
			sb.append((char)('0'+rem));
			n=n/b;
		}
		return sb.reverse().toString();
	}
}
