package Myclass;
import java.util.*;
public class sample1 {
	public static void main(String args[]) {
		System.out.println("Congratulations and Welcome to Zoho!");
		List<List<Integer>> list=new ArrayList<>();
		List<Integer> list1=new ArrayList<>();
		list1.add(1);
		list1.add(5);
		list.add(list1);
		List<Integer> list2=new ArrayList<>();
		list2.add(2);
		list2.add(3);
		list.add(list2);
		List<Integer> list3=new ArrayList<>();
		list3.add(6);
		list3.add(9);
		list.add(list3);
		for(List<Integer> al:list) {
			for(Integer item:al) {
				System.out.println(item);
			}
		}
		for(int i=0;i<list.size();i++) {
			
		}
	}
}
