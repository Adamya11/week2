import java.util.*;
import java.io.*;
class PrimeAnagram
{
    public static boolean isPrime(int num)
    {
        if(num == 2)
        return true;
        if(num%2 == 0)
        return false;
        for(int i=3;i<Math.sqrt(num)+1;i+=2)
        {
            if(num%i == 0)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram(int num)
    {
        int reverse;
        if(num < 12)
        return false;
        else if (num < 100)
        {
            int a = num%10;
            int b = num/10;
            reverse = a*10 + b;
            if(isPrime(reverse))
            return true;
            else return false;
        }
        else
        {
        int a = num%10;
        int b = (num/10)%10;
        int c = num/100;
        int an1 = c*100 + a*10 + b;
        int an2 = b*100 + a*10 + c;
        int an3 = b*100 + c*10 + a;
        int an4 = a*100 + b*10 + c;
        int an5 = a*100 + c*10 + b;
        if (an1 == num || an1<100)
        an1= 4;
        if (an2 == num || an2<100)
        an2= 4;
        if (an3 == num || an3<100)
        an3= 4;
        if (an4 == num || an4<100)
        an4= 4;
        if (an5 == num || an5<100)
        an5= 4;
        if(isPrime(an1) || isPrime(an2) || isPrime(an3) || isPrime(an4) || isPrime(an5)  )
        return true;
        else return false;
        }
    }
    public static void primeArray()
    {
        int index= 0;
        int count = 2;
        int [][]prime = new int[10][];
        int [][]primeAna = new int[10][];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for( int n=2;n<1000;n++)
        {   
            count++;
            if(isPrime(n) && isAnagram(n))
            {
                sb1.append(n);
                sb1.append(" ");
            }
            else if(isPrime(n))
            {
                sb2.append(n);
                sb2.append(" ");
            }
            if(count == 100)
            {
                String str1 = sb1.toString();
                String []str2 = str1.split(" ");
                primeAna[index] = new int[str2.length];
                for(int i=0;i<str2.length;i++)
                {
                    primeAna[index][i] = Integer.parseInt(str2[i]);
                }
                String str3 = sb2.toString();
                String []str4 = str3.split(" ");
                prime[index] = new int[str4.length];
                for(int i=0;i<str4.length;i++)
                {
                    prime[index][i] = Integer.parseInt(str4[i]);
                }
                index++;
                count = 0;
                int end1 = sb1.length();
                sb1.delete(0,end1);
                int end2= sb2.length();
                sb2.delete(0,end2);
            }
        }
            System.out.println("Anagram");
            for(int []row : primeAna)
            System.out.println(Arrays.toString(row));
            System.out.println("Not Anagram");
            for(int []row : prime)
            System.out.println(Arrays.toString(row));
    }
    public static void main(String args[])
    {
        primeArray();
    }
    
}