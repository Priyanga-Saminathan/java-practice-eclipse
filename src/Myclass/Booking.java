package Myclass;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Booking {
	public static void bookTaxi(int id,List<Taxi> freeTaxi,char pickupPoint,char dropPoint, int pickupTime) {
		int min=Integer.MAX_VALUE;
		char nextPoint='Z';
		int earning=0;
		int nextFreeTime=0;
		String tripDetail="";
		int dropTime=0;
		Taxi bookedTaxi=null;
		for(Taxi t:freeTaxi) {
			int distanceCurrentPickupPoint=Math.abs(t.currentSpot-'0'-pickupPoint-'0');
			if(distanceCurrentPickupPoint<min) {
				int distancePickupDrop=Math.abs((pickupPoint-'0')-(dropPoint-'0'))*15;
				earning=(distancePickupDrop-5)*10+100;
				nextFreeTime=pickupTime+Math.abs((pickupPoint-'0')-(dropPoint-'0'));
				nextPoint=dropPoint;
				System.out.println(nextFreeTime);
				dropTime=nextFreeTime;
				bookedTaxi=t;
				tripDetail=id+"   "+ pickupPoint+"   "+dropPoint+"   "+pickupTime+"   "+dropTime+"   "+earning; 
				min=distanceCurrentPickupPoint;
			}
		}
		bookedTaxi.setDetails(true,nextPoint,nextFreeTime,bookedTaxi.totalEarning+earning,tripDetail);
		System.out.println("Taxi "+bookedTaxi.id+" is booked");
	}
	public static List<Taxi> createTaxi(int n) {
		List<Taxi> taxis=new ArrayList<Taxi>();
		for(int i=0;i<n;i++) {
			Taxi t=new Taxi();
			taxis.add(t);
		}
		return taxis;
	}
	public static List<Taxi> freeTaxi(List<Taxi> taxis,char pickupPoint, int pickupTime) {
		List<Taxi> freeTaxi=new ArrayList<Taxi>();
		for(Taxi t:taxis) {
			if(t.freeTime<=pickupTime && Math.abs(t.currentSpot-'0'-(pickupPoint-'0'))<=pickupTime-t.freeTime) {
				freeTaxi.add(t);
			}
		}
		return freeTaxi;
	}
	public static void main(String args[]) {
		List<Taxi> Taxis=createTaxi(4);
		Scanner sc=new Scanner(System.in);
		int id=11;
		while(true) {
			System.out.println("0->Book taxi");
			System.out.println("1->taxi details");
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 0:
				System.out.println("Enter the pickup point:");
				char pickupPoint=sc.next().charAt(0);
				System.out.println("Enter the drop point:");
				char dropPoint=sc.next().charAt(0);
				System.out.println("enter the pick up time:");
				int pickupTime=sc.nextInt();
				List<Taxi> freeTaxi=freeTaxi(Taxis,pickupPoint,pickupTime);
				if(freeTaxi.size()<=0) {
					System.out.println("No taxi are available");
					break;
				}
//				Collections.sort(freeTaxi,(a,b)->a.totalEarning-b.totalEarning);
				Collections.sort(freeTaxi,new Comparator<Taxi>() {
					public int compare(Taxi a,Taxi b) {
						if(a.totalEarning==b.totalEarning) {
							return 0;
						}
						else if(a.totalEarning<b.totalEarning) {
							return -1;
						}
						else {
							return 1;
						}
					}
				});
//				System.out.println(freeTaxi);
//				
				bookTaxi(id,freeTaxi,pickupPoint,dropPoint,pickupTime);
				id++;
				break;
			case 1:
				for(Taxi t:Taxis) {
					t.printDetails();
				}
			}
			
				
			
			
		}
	}
}
