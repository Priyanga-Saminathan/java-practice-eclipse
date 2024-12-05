package Myclass;

//Online Java Compiler
//Use this editor to write, compile and run your Java code online

import java.util.*;
public class RailwayTicket{
 public static void bookTicket(Passenger p){
     TicketBooker booker=new TicketBooker();
     if(TicketBooker.availableWL==0){
         System.out.println("No ticket available");
         return;
     }
     if((p.preference.equalsIgnoreCase("L")&&TicketBooker.availableLowerBirth>0) || (p.preference.equalsIgnoreCase("M")&& TicketBooker.availableMiddleBirth>0) || (p.preference.equalsIgnoreCase("U")&&TicketBooker.availableUpperBirth>0) ){
         System.out.println("Prefered birth Available");
         if(p.preference.equalsIgnoreCase("L")){
             System.out.println("Lower birth given");
             booker.bookTicket(p,(TicketBooker.lowerBirthPosition.get(0)),"L");
             TicketBooker.availableLowerBirth--;
             TicketBooker.lowerBirthPosition.remove(0);
         }
         else if(p.preference.equalsIgnoreCase("M")){
             System.out.println("Middle birth given");
             booker.bookTicket(p,(TicketBooker.middleBirthPosition.get(0)),"M");
             TicketBooker.availableMiddleBirth--;
             TicketBooker.middleBirthPosition.remove(0);
         }
         else if(p.preference.equalsIgnoreCase("U")){
             System.out.println("Upper birth given");
             booker.bookTicket(p,(TicketBooker.upperBirthPosition.get(0)),"U");
             TicketBooker.availableUpperBirth--;
             TicketBooker.upperBirthPosition.remove(0);
         }
     }
         else if(TicketBooker.availableLowerBirth>0){
             System.out.println("Lower birth given");
             booker.bookTicket(p,(TicketBooker.lowerBirthPosition.get(0)),"L");
             TicketBooker.availableLowerBirth--;
             TicketBooker.lowerBirthPosition.remove(0);
         }
         else if(TicketBooker.availableMiddleBirth>0){
             System.out.println("Middle birth given");
             booker.bookTicket(p,(TicketBooker.middleBirthPosition.get(0)),"M");
             TicketBooker.availableMiddleBirth--;
             TicketBooker.middleBirthPosition.remove(0);
         }
         else if(TicketBooker.availableUpperBirth>0){
             System.out.println("Upper birth given");
             booker.bookTicket(p,(TicketBooker.upperBirthPosition.get(0)),"U");
             TicketBooker.availableUpperBirth--;
             TicketBooker.upperBirthPosition.remove(0);
         }
         else if(TicketBooker.availableRac>0){
              System.out.println("RAC given");
             booker.addToRac(p,(TicketBooker.racPosition.get(0)),"RAC");
             TicketBooker.availableRac--;
             TicketBooker.racPosition.remove(0);
         }
         else if(TicketBooker.availableWL>0){
             System.out.println("WL given");
             booker.addToWL(p,(TicketBooker.wlPosition.get(0)),"WL");
             TicketBooker.availableWL--;
             TicketBooker.wlPosition.remove(0);
         }
     }
 public static void cancelTicket(int id){
     TicketBooker booker=new TicketBooker();
     if(!TicketBooker.passengers.containsKey(id)){
         System.out.println("This id is not available in booked list");
     }
     else{
         booker.cancelTicket(id);
     }
         
 }
 public static void main(String[] args) {
     System.out.println("Try programiz.pro");
     Scanner sc=new Scanner(System.in);
     boolean loop=true;
     while(loop){
         System.out.println("1.Book ticket \n 2.Cancel ticket \n 3.Available ticket\n 4.Display booked tickets \n 5.Exit");
         int choice=sc.nextInt();
         switch(choice){
             case 1:{
                 System.out.println("Enter passenger name, age, preference");
                 String name=sc.next();
                 int age=sc.nextInt();
                 String preference=sc.next();
                 Passenger p=new Passenger(name,age,preference);
                 bookTicket(p);
             }
             break;
             case 2:{
                 System.out.println("Enter id to cancel ticket:");
                 int id=sc.nextInt();
                 cancelTicket(id);
             }
             break;
             case 3:{
                 System.out.println("Available tickets are below");
                 TicketBooker booker=new TicketBooker();
                 booker.printAvailable();
             }
             break;
             case 4:{
                 System.out.println("Booking details of passenger");
                 TicketBooker booker=new TicketBooker();
                 booker.passengerDetails();
             }
             break;
             case 5:{
                 loop=false;
             }
         }
     }
 }
}
