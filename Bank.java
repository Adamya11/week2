import java.io.*;
import java.util.*;

class Bank
{
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }
    }
    public void enqueue(int d)
    {
        Node m = new Node(d);
        Node curr=head;
        if(head == null)
        {
            head=m;
        
        }
        else
        {while(curr.next != null)
        {
            curr=curr.next;
        }
        curr.next = m;
        }
    }
    public int dequeue()
    {
        Node curr = head;
        Node last = head;
        int customerBalance = head.data;
        head = curr.next;
        last.next = null;
        return customerBalance;
    }
    public boolean isEmpty()
    {
        if(head == null)
        return true;
        else
        return false;
    }




    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        Bank ob= new Bank();
        int bankBalance=0;
        int money = 0;
        int customerBalance=0;
        char panel=' ';
        while(true)
        {
            System.out.println("Press 'q' if you want to add people to queue & 'd' if you want to remove them");
            System.out.println("Press 'e' to exit");
            panel=sc.next().charAt(0);
            if(panel == 'q')
            {
                System.out.println("Enter amount to be deposited or withdrawn");
                money=sc.nextInt();
                ob.enqueue(money);
            }
            else if(panel == 'd' && !ob.isEmpty())
            {
                customerBalance=ob.dequeue();
                bankBalance = bankBalance + customerBalance;
                // System.out.println(bankBalance);        
            }
            else if(panel == 'd' && ob.isEmpty())
            {
                System.out.println("The queue is empty.");
            }
            else if (panel == 'e')
            break;
            
        }
        System.out.println(bankBalance);
    }
}