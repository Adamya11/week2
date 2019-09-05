import java.util.*;

class StackPrime{
    Node head;
    class Node{
        Node next;
        int data;
        Node(int d){
           data=d;
           next=null; 
        }
    }
    public void push(int d){
        Node n1 = new Node(d);
        if(head== null){
            head=n1;
        }
        else{
            n1.next=head;
            head = n1;
        }
    }

    public int pop(){
        Node curr = head;
        Node pre = head;
        int data1 = head.data;
        head = curr.next;
        pre.next =null;
        return data1;

    }

    public boolean isEmpty(){
        if(head==null)
        return true;
        else
        return false;
    }


public static boolean isPrime(int n){
    if(n==2)
    return true;
    if(n%2 == 0)
    return false;
    for(int i=3;i<Math.sqrt(n);i=i+2)
    {
        if(n%i == 0)
        return false;
    }
    return true;
}

public static boolean anagrams(int numb){
    int reverse;
    if(numb<12)
    return false;
    else if(numb<100)
    {
        int a = numb%10;
        int b = numb/10;
        reverse = a*10 + b;
        if(isPrime(reverse))
        return true;
        else return false;
    }
    else
    {
        int a = numb%10;
        int b = (numb/10)%10;
        int c = numb/100;
        int an1 = a*100 + b*10 + c*1;
        int an2 = a*100 + b*1 + c*10;
        int an3 = a*10 + b*100 + c*1;
        int an4 = a*1 + b*100 + c*10;
        int an5 = a*10 + b*1 + c*100;
        if(an1 == numb || an1<100)
        an1 = 4;
        //if(an2 == numb || an2<100)
        //an2 = 4;
        //if(an3 == numb || an3<100)
        //an3 = 4;
        if(an4 == numb || an4<100)
        an4 = 4;
        if(an5 == numb || an5<100)
        an5 = 4;
        if(isPrime(an1) || isPrime(an2) || isPrime(an3) || isPrime(an4) || isPrime(an5))
        return true;
        else return false;
    }
}

public static void primeArray(){
    int num = 2;
    int count = 2;
    int index = 0;
    int [][]prime = new int[10][];
    int [][]pAnagram = new int[10][];
    StackPrime ob=new StackPrime();
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for(num=2;num<1000;num++)
    {
         if(isPrime(num) && anagrams(num))
        {
            ob.push(num);
        }
        while(!ob.isEmpty())
        System.out.println(ob.pop());
        
    }
} 
public static void main(String args[]){
    primeArray();
    
}
}