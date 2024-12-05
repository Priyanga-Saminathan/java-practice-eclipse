package Myclass;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
public class linkedlist {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        ListNode node1=new ListNode(10);
        node1.next=new ListNode(20);
        node1.next.next=new ListNode(30);
        ListNode current=node1;
        while(current!=null){
            System.out.println(current.val);
            current=current.next;
        }
        System.out.println(node1.val);
    }
}
