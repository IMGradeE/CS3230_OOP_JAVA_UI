package MiscSolutionClasses;

import java.util.Scanner;

/**
 This program computes how many steps the sum 1 + 1/2 + 1/3 + ...
 needs to exceed a given target.
 */
public class ReciprocalSum
{
    public static void main(String[] args)
    {

        double sum = 0;
        int n = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Target: ");
        double target = in.nextDouble();

        /* Your code goes here */
        while (sum <= target){
            ++n;
            sum += 1/(double)n;
        }
        System.out.println("n: " + n);
        System.out.println("sum: " + sum);
    }
}