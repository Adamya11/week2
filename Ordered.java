import java.util.*;
import java.io.*;
public class Ordered
{
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void add(int d)
    {
        Node m = new Node(d);
        if(head == null)
        {
            head=m;
        }
        else if(head.data>=d)
        {
            m.next = head;
            head = m;
        }
        else 
        {
            Node current = head;
            Node previous = head;
            if(current.next != null)
            current = current.next;
            while((current.data < d) && (current.next != null))
            {
            current = current.next;
            previous = previous.next;
            }
            if(current.data < d)
            {
            current.next = m;
            }
            else
            {
            m.next = previous.next;
            previous.next = m;
            }

    }
    }
    public void delete(int s)
    {
        Node curr = head;
        Node prev = head;
        if(head.data == s)
        {
            head = curr.next;
            prev.next = null;
        }
        else
        {
            curr = curr.next;
            while(curr.data !=s)
            {
                curr=curr.next;
                prev=prev.next;
            }
            prev.next = curr.next;
            curr.next = null;
        }
    }
    public boolean search(int s)
    {
        Node curr = head;
        while(curr.next != null)
        {
            if(curr.data == s)
            {
                return true;
            }
            curr = curr.next;
        }
        if(curr.data == s)
        return true;
        else
        return false;
    }
    public void print()
    {
        Node curr = head;
        while(curr.next != null)
        {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
    public static int[] read() throws Exception
    {
        FileReader fr = new FileReader("/home/admin1/Desktop/week2/hello.txt");
        StringBuilder sb = new StringBuilder();
        int i;
        while ((i=fr.read())!= -1)
        {
            sb.append((char)i);
        }
        String s1= sb.toString();
        String []s2= s1.split(" ");
        int []num= new int[s2.length];
        for(int j=0;j<s2.length;j++)
        {
            num[j] = Integer.parseInt(s2[j]);
        }
        return num;
    }
    public void write() throws Exception
    {
        PrintWriter pr = new PrintWriter("/home/admin1/Desktop/week2/text2.txt");
        Node curr = head;
        while(curr.next != null)
        {
            pr.write(Integer.toString(curr.data));
            curr = curr.next;
            pr.write(" ");
        }
        pr.write(Integer.toString(curr.data));
        pr.flush();
        pr.close();
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int numbers[] = read();
        Ordered obj = new Ordered();
        for(int i=0;i<numbers.length;i++)
        {
            obj.add(numbers[i]);
        }
        System.out.println("Enter a number you want to search");
        int n = sc.nextInt();
        boolean found = obj.search(n);
        if(found)
        obj.delete(n);
        if(!found)
        obj.add(n);
        obj.print();
    }
}