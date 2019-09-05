import java.util.*;
import java.io.*;

public class LinkedList
{
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }   
    }
    public void printList()
    {
        Node n = head;
        while(n!=null)
        {
            System.out.print(n.data+ " ");
            n=n.next;
        }
    }
    
    public void insertatstart(int x)
    {
        Node m= new Node(x);
        m.next= head;
        head= m;
    }
    public void insertatmid(Node y, int z)
    {
        Node m=new Node(z);
        m.next=y.next;
        y.next=m; 
    }

    public void insertatend(int z)
    {
        Node m = new Node(z);
        if(head==null)
        {
            head= new Node(z);
            return;
        }
        m.next=null;
        Node last = head;
        while(last.next!=null)
        {
            last=last.next;
        }
        last.next=m;
    
    }
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
        llist.head = new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        llist.head.next = n2;
        n2.next= n3;
        n3.next= n4;
        n4.next= null;
        System.out.println("initial list:");
        llist.printList();
        llist.insertatmid(n2,20);
        System.out.println("new list:");
        llist.printList();
        llist.insertatstart(10);
        System.out.println("updated list:");
        llist.printList();
         llist.insertatend(50);
        System.out.println("updated list:");
        llist.printList();

    }
}