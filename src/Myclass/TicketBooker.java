package Myclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Passenger{
	 static int id=1;
	 String name;
	 int age;
	 String preference;
	 int passengerId;
	 String alloted;//birth
	 int number;//seat number
	 Passenger(String name,int age,String preference){
	     this.name=name;
	     this.age=age;
	     this.preference=preference;
	     this.passengerId=id++;
	     alloted="";
	     number=0;
	 }
	}
class TicketBooker{
	 static int availableLowerBirth=1;
	 static int availableMiddleBirth=1;
	 static int availableUpperBirth=1;
	 static int availableRac=1;
	 static int availableWL=1;
	 
	 static Queue<Integer> waitingList=new LinkedList<>();
	 static Queue<Integer> racList=new LinkedList<>();
	 static List<Integer> bookedTicketList=new ArrayList<>();
	 
	 static List<Integer> lowerBirthPosition=new ArrayList<>(Arrays.asList(1));
	 static List<Integer> middleBirthPosition=new ArrayList<>(Arrays.asList(1));
	 static List<Integer> upperBirthPosition=new ArrayList<>(Arrays.asList(1));
	 static List<Integer> racPosition=new ArrayList<>(Arrays.asList(1));
	 static List<Integer> wlPosition=new ArrayList<>(Arrays.asList(1));
	 
	 static Map<Integer,Passenger> passengers=new HashMap<>();
	 public void bookTicket(Passenger p, int birthInfo, String allotedBirth){
	     p.number=birthInfo;
	     p.alloted=allotedBirth;
	     passengers.put(p.passengerId,p);
	     bookedTicketList.add(p.passengerId);
	     System.out.println(" Booked Passenger id:"+bookedTicketList.getLast());
	     System.out.println(bookedTicketList);
	     System.out.println("-----Booked successfully-----");
	 }
	 public void addToRac(Passenger p,int racInfo, String allotedRac){
	     p.number=racInfo;
	     p.alloted=allotedRac;
	     passengers.put(p.passengerId,p);
	     racList.add(p.passengerId);
	     System.out.println("RAC Passenger id:"+p.passengerId);
	 }
	 public void addToWL(Passenger p,int wlInfo, String allotedWL){
	     p.number=wlInfo;
	     p.alloted=allotedWL;
	     passengers.put(p.passengerId,p);
	     waitingList.add(p.passengerId);
	     System.out.println("WL Passenger id:"+p.passengerId);

	 }
	 public void cancelTicket(int passengerId){
	     Passenger p=passengers.get(Integer.valueOf(passengerId));
	     passengers.remove(Integer.valueOf(passengerId));
	     bookedTicketList.remove(Integer.valueOf(passengerId));
	     int positionBooked=p.number;
	     Passenger rac=passengers.get(racList.poll());
	     System.out.println("Ticket cancelled successfully");
	     if(p.alloted.equals("L")){
	         availableLowerBirth++;
	         lowerBirthPosition.add(positionBooked);
	         RailwayTicket.bookTicket(rac);
	     }
	     else if(p.alloted.equals("M")){
	         availableMiddleBirth++;
	         middleBirthPosition.add(positionBooked);
	         RailwayTicket.bookTicket(rac);
	     }
	     else if(p.alloted.equals("U")){
	         availableUpperBirth++;
	         upperBirthPosition.add(positionBooked);
	         RailwayTicket.bookTicket(rac);
	     }
	     else if(p.alloted.equals("RAC")) {
//	    	 availableRac++;
//	    	 racPosition.add(positionBooked);
//	    	 racList.remove(Integer.valueOf(passengerId));
//	    	 Passenger racPassenger=passengers.get(passengerId);
//	         int racPositionalloted=p.number;
	         racPosition.add(positionBooked);
	         racList.remove(p.passengerId);
	         availableRac++;
	         if(waitingList.size()>0){
	             Passenger wlPassenger=passengers.get(waitingList.poll());
	             int wlPositionalloted=wlPassenger.number;
	             wlPosition.add(wlPositionalloted);
	             waitingList.remove(wlPassenger.passengerId);
	             availableWL++;
	             wlPassenger.number=racPosition.get(0);
	             wlPassenger.alloted="RAC";
//	             racPosition.remove(0);
//	             availableRac--;
//	             racList.add(wlPassenger.passengerId);
	             addToRac(wlPassenger,wlPassenger.number,wlPassenger.alloted);
	         }
	         
	     }
	     else if(p.alloted.equals("WL")) {
	    	 availableWL++;
	    	 wlPosition.add(positionBooked);
	    	 waitingList.remove(Integer.valueOf(passengerId));
	     }
//	     if(racList.size()>0){
//	         Passenger racPassenger=passengers.get(racList.poll());
//	         int racPositionalloted=racPassenger.number;
//	         racPosition.add(racPositionalloted);
//	         racList.remove(racPassenger.passengerId);
//	         availableRac++;
//	         if(waitingList.size()>0){
//	             Passenger wlPassenger=passengers.get(waitingList.poll());
//	             int wlPositionalloted=wlPassenger.number;
//	             wlPosition.add(wlPositionalloted);
//	             waitingList.remove(wlPassenger.passengerId);
//	             availableWL++;
//	             wlPassenger.number=racPosition.get(0);
//	             wlPassenger.alloted="Rac";
//	             racPosition.remove(0);
//	             availableRac--;
//	             racList.add(wlPassenger.passengerId);
//	         }
//	         RailwayTicket.bookTicket(racPassenger);
//	     }
	 }
	 public void printAvailable(){
	     System.out.println("Available lower birth:"+availableLowerBirth);
	     System.out.println("Available middle birth:"+availableMiddleBirth);
	     System.out.println("Available upper birth:"+availableUpperBirth);
	     System.out.println("Available rac:"+availableRac);
	     System.out.println("Available WL:"+availableWL);
	     
	 }
	 public void passengerDetails(){
	     if(passengers.size()==0){
	         System.out.println("No passengers details available");
	         return;
	     }
	         for(Passenger p:passengers.values()){
	             System.out.println("Passenger id:"+p.passengerId);
	             System.out.println("Passenger name:"+p.name);
	             System.out.println("Passenger age:"+p.age);
	             System.out.println("Passenger status:"+p.number+p.alloted);
	             System.out.println("-------------");
	         }
	 }
	 
	}

