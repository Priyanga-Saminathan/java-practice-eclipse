package Myclass;

public class threadname extends Thread{
	public void run() {
		System.out.println("Running");
	}
	public static void main(String args[]) {
		Thread t1=new Thread("New Thread");
		String str=t1.getName();
		t1.start();
		System.out.println(str);
//		t1.getName();
	}
	
}
class Name extends Thread{
//	Name(String str){
//		super(str);
//	}
	public void run() {
		System.out.println("Thraed running");
	}
}
