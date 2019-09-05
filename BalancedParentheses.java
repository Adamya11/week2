import java.util.*;

class BalancedParentheses{
class Node{
    char data;
    Node next;
    Node(char d)
    {
        data=d;
        next=null;
    }
}

Node head;

public void push(char d){
    Node temp = new Node(d);
    if(head==null)
    {
        head = temp;
    }
    else 
    {
        temp.next = head;
        head = temp;
    }
}

public void pop(){
    Node current = head;
    Node previous = head;
    head = current.next;
    previous.next = null;   
}

public void peak(){
    Node current = head;
    System.out.println(current.data);
}

public boolean isEmpty(){
    if(head == null)
    return true;
    else 
    return false;
}

public int size(){
    Node current = head;
    int count = 0;
    while(current.next != null)
    {
        current = current.next;
        count++;
    }
    return ++count;
}

public static void main(String args[]){
    System.out.println("Enter your expression");
    Scanner sc = new Scanner(System.in);
    String exp = sc.nextLine();
    sc.close();
    char []par = exp.toCharArray();
    BalancedParentheses ob = new BalancedParentheses();
    try
    {
        for(int i=0;i<par.length;i++)
        {
            if(par[i]=='(')
            ob.push(par[i]);
            else if(!(ob.isEmpty()) && par[i]==')')
            ob.pop();
            else if((ob.isEmpty()) && par[i]==')')
            throw new ArithmeticException();
        }
        if(ob.isEmpty())
        System.out.println("Balanced");
        else
        System.out.println("Not Balanced");
    }
    catch(ArithmeticException e)
    {
        System.out.println("Not Balanced");        
    }
}
}