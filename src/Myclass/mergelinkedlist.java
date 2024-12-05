package Myclass;
class Node{
	int val;
	Node next;
	public Node(int val) {
		this.val=val;
		this.next=null;
	}
}
public class mergelinkedlist {
	public static void main(String args[]) {
		Node n1=new Node(10);
		n1.next=new Node(20);
		n1.next.next=new Node(30);
		Node n2=new Node(5);
		n2.next=new Node(15);
		n2.next.next=new Node(25);
		n2.next.next.next=new Node(35);
		n2.next.next.next.next=new Node(45);
//		Node cur=n2;
//		System.out.println(n2);
//		while(current!=null) {
//			System.out.println(current.val);
//			current=current.next;
//		}
		merge(n1,n2);
	}
	public static void merge(Node n1, Node n2) {
		Node res=new Node(0);
		Node head=res;
		while(n1!=null && n2!=null) {
			if(n1.val<=n2.val) {
				res.next=n1;
				n1=n1.next;
			}
			else {
				res.next=n2;
				n2=n2.next;
			}
			res=res.next;
		}
		if(n1==null) {
			res.next=n2;
		}
		else if(n2==null) {
			res.next=n1;
		}
		head=head.next;
		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
	}
}
