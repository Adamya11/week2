import java.util.*;
import java.io.*;

public class Palindrome
{
    Node head;
    class Node
    {
        char data;
        Node next;
        Node(char d)
        {
            data=d;
            next=null;
        }
    }
    public void addFront(char d)
    {
        Node m = new Node(d);
        if(head == null)
        {
            head=m;
        }
        else
        {
            m.next=head;
            head=m;
        }
    }
    public void addRear(char d)
    {
        Node m = new Node(d);
        Node curr = head;
        if(head==null)
    {
        head = m;
    }
    else 
    {
        while(curr.next != null)
        {
            curr=curr.next;
        }
        curr.next = m;
        
    }}
    public char removeFront()
    {
        Node curr = head;
        Node prev = head;
        char front = head.data;
        head = curr.next;
        prev.next = null;
        return front;
    }
    public char removeRear()
    {
        Node curr = head;
        Node prev = head;
        char rear;
        if(curr.next != null)
        curr = curr.next;
        while(curr.next != null)
        {
            curr = curr.next;
            prev =  prev.next;
        }
        rear = curr.data;
        curr = null;
        prev.next = null;
        return rear;
    }
    public boolean isEmpty()
    {
        if(head == null)
        return true;
        else
        return false;
    }
    public int size()
    {
        Node curr = head;
        int count = 0;
        while(curr.next != null)
        {
            curr = curr.next;
            count ++;
        }
        return ++count;
    }
    public static void main (String args[])
    {

        Palindrome obj = new Palindrome();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word to check if it's Palindrome");
        String s1 = sc.nextLine();
        String s2 = s1.toLowerCase();
        char []arr = s2.toCharArray();
        for(int i=0;i<arr.length;i++)
        {
            obj.addRear(arr[i]);
        }
        char front;
        char rear;
        while(obj.size() > 1)
        {
            front = obj.removeFront();
            rear  = obj.removeRear();
            if(front != rear)
            {break;} 
        }
        if(obj.size() < 2)
        System.out.println("Palindrome");
        else
        System.out.println("Not Palindrome");
    }
}