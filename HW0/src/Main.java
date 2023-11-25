import java.io.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<=i; j++)
            {
                System.out.print("*");
            }
            System.out.println();

        }
        printIndexed("ZELDA");
        stutter("Hello");
        quadrant(2,4);
        System.out.println("Hello world!");
    }
    public static void printIndexed(String a)
    {
        int totalLen=a.length();
        String str="";
        for (int i=totalLen-1;i>=0;i--)
        {
            str+=a.charAt(totalLen-1-i)+String.valueOf(i);
        }
        System.out.println(str);


    }

    public static String stutter(String a)
    {
        StringBuilder out= new StringBuilder();
        for (int i=0;i<=a.length()-1;i++)
        {
            out.append(a.charAt(i)).append(a.charAt(i));
            /*System.out.println(out);*/
        }
        System.out.println(out.toString());
        return out.toString();
    }

    public static int quadrant(double i, double j)
    {
        if (i ==0 || j==0)
            return 0;
        else if(i>0 && j >0)
            return 1;
        else if(i>0 && j <0)
            return 4;
        else if(i<0 && j <0)
            return 3;
        else return 2;
    }
}
