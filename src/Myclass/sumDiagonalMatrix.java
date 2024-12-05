package Myclass;
import java.util.*;
public class sumDiagonalMatrix {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int mat[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				mat[i][j]=sc.nextInt();
			}
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(i==j) {
					sum+=mat[i][j];
				}
				else if(i+j==n-1) {
					sum+=mat[i][j];
				}
			}
		}
		int d=n/2;
//		sum=sum-mat[d][d];
		System.out.println(sum);
		sum(mat,n);
	}
	public static void sum(int[][] mat,int n) {
		int s=0;
		for(int i=0;i<n;i++) {
			s+=mat[i][i];
			s+=mat[i][n-1-i];
		}
		if(n%2!=0) {
			s-=mat[n/2][n/2];
		}
		System.out.println(s);
	}
}
