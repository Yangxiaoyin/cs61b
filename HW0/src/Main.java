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
}
