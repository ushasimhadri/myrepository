import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoStacks {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int queryno=sc.nextInt();
        Stack<Integer> front=new Stack<Integer>();
         Stack<Integer> rear=new Stack<Integer>();
         int choice;
         for(int i=0;i<queryno;i++)
         {
             choice=sc.nextInt();

             if(choice==1)
             {
             rear.push(sc.nextInt());
             }

             else
             {
                 if(front.isEmpty())
                 {
                     while(!rear.isEmpty())
                     {
                         front.push(rear.pop());

                     }
                 }

                 if(choice==2)
                 front.pop();
                 else if(choice==3)
                 System.out.println(front.peek());

             }

             
         }
    }
}

