import java.util.*;
import java.io.*;

class Calendar{

public static int days(int m, int y){
int d=1;

int y1 = y - (14 - m) / 12;
int x = y1 + y1/4 - y1/100 + y1/400;
int m1 = m + 12*((14 - m)/12) - 2;
int d1 = (d + x + 31*m1/12)%7;

return d1;
}
    public static void main(String args[]){
        int m=Integer.parseInt(args[0]);
        int y=Integer.parseInt(args[1]);
        int day = days(m,y);
        int num=1;
        int count=0;
        String c[][]= {
                        {" S"," M"," T"," W"," T"," F"," S"},
                        {"  ","  ","  ","  ","  ","  ","  "},
                        {" "," "," "," "," "," "," "},
                        {" "," "," "," "," "," "," "},
                        {" "," "," "," "," "," "," "},
                        {" "," "," "," "," "," "," "},
                        {" "," "," "," "," "," "," "},
                        };

        String [][]b = {
                        {"January","February","March","April","May","June","July","August","September","October","November","December"},
                        {"31","28","31","30","31","30","31","31","30","31","30","31"}

                        };
        aa:
        for(int i=1;i<7;i++){
            for(int j=0;j<7;j++){
                if(count<day){
                    count++;
                    continue;
                }
                if(num<10)
                    c[i][j] = String.format(" %d", num);
                else 
                    c[i][j] = String.format("%d", num);
                num++;
                    if(num > Integer.parseInt(b[1][m-1]))
                    break aa;
                }
            }

            System.out.println(b[0][m-1] + " " + y);
            for(int i=0;i<7;i++){
                for(int j=0;j<7;j++){
                    System.out.print(c[i][j]);
                     System.out.print(" ");
                }
                System.out.println("");

            }
        }

       
}