package Myclass;
import java.util.*;
public class Taxi {
	static int taxicount=0;
	int id;
	char currentSpot;
	int freeTime;
	int totalEarning;
	boolean booked;
	List<String> trip;
	public Taxi() {
		booked=false;
		currentSpot='A';
		freeTime=6;
		totalEarning=0;
		taxicount++;
		id=taxicount;
		trip=new ArrayList<String>();
	}
	public void setDetails(boolean booked,char currentSpot,int freeTime,int totalEarning,String tripDetail) {
		this.booked=booked;
		this.currentSpot=currentSpot;
		this.freeTime=freeTime;
		this.totalEarning=totalEarning;
		this.trip.add(tripDetail);
		
		
	}
	public void printDetails() {
//		for(String trips:trip) {
//			System.out.println(trips);
//			
//		}
		System.out.println(this.id+"  "+this.totalEarning+"   "+this.currentSpot+"   "+this.freeTime);
	}
}
