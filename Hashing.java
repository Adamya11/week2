import java.util.*;
import java.io.*;
class Hashing
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
    public int[] read() throws Exception
    {
        FileReader fr = new FileReader("/home/admin1/Desktop/week2/hello.txt");
        StringBuilder sb = new StringBuilder;
        int i;
        while((i=fr.read())!= -1)
        {
            sb.append((char)i);
        }
        String s1 = sb.toString();
        String []s2 = s1.split(" ");
        int []num = new int[s2.length];
        for(i=0;i<s2.length;i++)
        {
            num[i] = Interger.parseInt(s2[j]);
        }
        return num;
    }
    public void write(int m) throws Exception
    {
        PrintWriter pw = new PrintWriter("/home/admin1/Desktop/week2/text3.txt");
        Node current = head;
        if(current == null)
        {
            pw.write("/n");
        }
        else
        while((current.next)!= null)
        {
            pw.write(Integer.toString(current.data);
            pw.write(" ");
            current = current.next;
        }
        pw.write(Integer.toString(current.data);
        pw.write(" ");
        if(m == 10)
        {
            pw.flush();
            pw.close();
        }

    }
    public boolean search(int d)
    {
        Node current = head;
        if(current == null)
        {
            return false;
        }
        while((current.next)!= null)
        {
            if(current.data = d)
            {
                return true;
            }
            current = current.next;
        }
        if(current.data = d)
        return true;
        else
        return false;
    }
    public void delete(int d)
    {
        Node current = head;
        Node prev = head;
        if (current.data = d)
        {
            head = current.next;
            prev.next = null;
        }
        else 
        if((current.next)!= null)
        current = current.next;
        while((current.data)!= d)
        {
            current = current.next;
            prev = prev.next;
        }
        prev.next = current.next;
        current.next = null;   
    }
    public void add(int num)
    {
        Node temp = new Node(num);
        if(head == null)
        {
            head= temp;
            temp.next = null;
        }
        else if (head.data > d)
        {
            temp.next = head;
            head = temp;
        }
        else
        Node current = head;
        Node prev = head;
        if((current.next)!= null)
        current = current.next;
        while(current.data < d  && (current.next)!= null)
        {
            current = current.next;
            prev = prev.next;
        }
        if(current.data < d)
        {
            current.next = temp;
            temp.next = null;
        }
        else
        temp.next = prev.next;
        prev.next = temp;
    }
    public void print()
    {
        Node current = head;
        while((current.next)!= null)
        {
            System.out.print(current.data);
            System.out.print(" ");
            current = current.next;
        }
            System.out.print(current.data);
            
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner();
        int []numbers= read();
        Hashing slot[] = new Hashing[11];
        for(int k=0;k<11;k++)
        {
            slot[k] = new Hashing();
        }
        int index= 0;
        for(int i=0;i<numbers.length;i++)
        {
            index=numbers[i]%11;
            slot[index].add(numbers[i]);
        }
        System.out.println("Enter the number to be searched");
        int n = sc.nextInt();
        index = n%11;
        boolean found = slot[index].search(n);
        if(found)
        slot[index].delete(n);
        else if (found!)
        slot[index].add(n);
        for(int p=0;p<11;p++)
        {
            slot[p].print();
        }

    }
}