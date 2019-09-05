import java.util.*;
import java.io.*;
class BinarySearchTree
{
    public static int binomialCoef(int n , int r)
    {
        int res = 1;
        if(r > n-r)
        {
            r = n-r;
        }
        for(int i=0;i<r;i++)
        {
            res *= (n-i);
            res /= (i+1);
        }
        return res;
    }
    public static int catalan(int n)
    {
        int c = binomialCoef(2*n , n);
        return c/(n + 1);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int n = sc.nextInt();
        int count = catalan(n);
        System.out.println("Number of BSTs for" + n + " nodes is " + count);
    }
}