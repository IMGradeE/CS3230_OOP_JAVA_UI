package MiscSolutionClasses;

import java.util.Scanner;

public class SumIfNotZeroOrSequentialDupe
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int previous;
        int sum = 0;
        int x = 0;

        do{
            previous = x;
            x = Integer.parseInt(in.next());
            sum += x;
        }while ( x!= previous &&  x != 0 );

        System.out.println("Sum: " + sum);
    }
}
