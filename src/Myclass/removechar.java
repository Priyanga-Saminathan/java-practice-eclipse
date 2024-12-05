package Myclass;

import java.util.Scanner;

public class removechar {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		String str=remove(s1,s2);
		System.out.println(str);
		sc.close();
	}
	public static String remove(String s1, String s2) {
		char arr1[]=s1.toCharArray();
		char arr2[]=s2.toCharArray();
		for(int i=0;i<s2.length();i++) {
			for(int j=0;j<s1.length();j++) {
				if(arr2[i]==arr1[j]) {
					arr1[j]=' ';
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s1.length();i++) {
			if(arr1[i]!=' ') {
				sb.append(arr1[i]);
			}
		}
		return sb.toString();
	}
}
