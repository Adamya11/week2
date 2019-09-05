import java.io.*;
import java.util.*;

class Testing{
   
    class Node{
        Node next;
        String data;
        Node(String d){
            data=d;
            next=null;
        }
    }
     Node head;

    public void add(String d){
        Node n1 = new Node(d);
        if(head==null){
            head=n1;
        }
        else
        {
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=n1;
        
    }
    }

    public static String[] readin() throws Exception{
        FileReader fr=new FileReader("/home/admin1/Desktop/week2/textt.txt");
        StringBuilder s1=new StringBuilder();
        int i;
        while((i=fr.read())!=-1)
            s1.append((char)i);
            String a = s1.toString();
            String word[]=a.split(" ");
            return word;
        
    }

    public void write() throws Exception{
        PrintWriter wr=new PrintWriter("/home/admin1/Desktop/week2/hello.txt");
        Node curr=head;
        while(curr.next!=null)
        {
            wr.write(curr.data);
            curr=curr.next;
            wr.write(" ");

        }
        wr.write(curr.data);
        wr.flush();
        wr.close();
    }

    public boolean search(String s){
        Node curr=head;
        while(curr.next!= null){
            if((curr.data).equals(s)){
            return true;
        }
        curr=curr.next;
        }
        if((curr.data).equals(s))
        return true;
        else
        return false;
    }
    public void delete(String del){
        Node curr=head;
        Node pre=head;
        if(curr.data.equals(del))
        {
            head=curr.next;
            pre.next=null;
            pre.data=null;
        }
        else
        {
            curr=curr.next;
            while(!(curr.data.equals(del))){
                curr=curr.next;
                pre=pre.next;
            }
            pre.next=curr.next;
            curr.next=null;
            curr.data=null;
        }
    }

    
    public static void main(String args[]) throws Exception{
        Scanner sc=new Scanner(System.in);
        String [] words=readin();
        Testing ob=new Testing();
        for(int i=0;i<words.length;i++){
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