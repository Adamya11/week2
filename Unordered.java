import java.io.*;
import java.util.*;

class Unordered
{
    Node head;
    class Node
    {
        String data;
        Node next;
        Node(String d)
        {
            data=d;
            next=null;
        }
    }
    public void add(String d)
    {   
        Node n = new Node(d);
        if(head==null)
        {
            head=n;
        }
        else
        {
            Node last=head;
        while(last.next!=null)
        {
            last=last.next;
        }
        last.next=n;
        n.next=null;}
    }
    public static String[] read() throws Exception
    {
        FileReader fr= new FileReader("/home/admin1/Desktop/week2/hello.txt");
        StringBuffer sb= new StringBuffer();
        int i;
        while((i=fr.read())!=-1)
        sb.append((char)i);
        String a = sb.toString();
        String word[] = a.split(" ");
        return word;
    }
    public void write() throws Exception
    {
        PrintWriter pr= new PrintWriter("/home/admin1/Desktop/week2/textt.txt");
        Node curr= head;
        while(curr.next!=null)
        {
            pr.write(curr.data);
            curr=curr.next;
            pr.write(" ");
        }
        pr.write(curr.data);
        pr.flush();
        pr.close();
    }
    public boolean search(String d)
    {
        Node curr=head;
        while(curr.next!=null)
        {
            if((curr.data).equals(d))
            {return true;}
            curr=curr.next;
        }
        if((curr.data).equals(d))
        return true;
        else 
        return false;
    }
    public void delete(String d)
    {
        Node curr=head;
        Node last=head;
        if(curr.data.equals(d))
        {
            head = curr.next;
            last.next = null;
        }
        else
        {
        curr = curr.next;
        while(!(curr.data).equals(d))
        {
            curr=curr.next;
            last=last.next;
        }
        last.next=curr.next;
        curr.next=null;
        curr.data=null;
    }}

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String[] words= read();
        Unordered ob= new Unordered();
        for(int i=0;i<words.length;i++)
        {    
            ob.add(words[i]);
        }
        System.out.println("enter words to be searched");
        String s=sc.nextLine();
        boolean found=ob.search(s);
        if(found)
        ob.delete(s);
        else if(!found)
        ob.add(s);
        ob.write();
    }
}