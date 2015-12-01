/**
 * Created by Niranjan on 8/28/2015.
 */

import java.util.*;

public class MinimumNumber {



    public static void main(String args[]){

        //header
        System.out.println("Program for Finding the Minimum Number in a Sequence");
        System.out.println("-----------------------------------------------------");

        //Initialize the scanner class to get the input
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your choice of Reading from a file or Input in Console");


        //get the input for the size of the sequence
        System.out.println("Please Enter the Size of the Sequence (i.e.,) the number of individual" +
                " numbers that are present in the sequence..");
        int size = in.nextInt();

        //initialize the array with the size of the sequence
        int sequence[] = new int[size];

        //storing the input into the array
        for (int i=0;i<=size-1;i++){
            System.out.println("Enter the number that needs to be added to the sequence...");
            sequence[i]=in.nextInt();
        }


        //finding the minimum number in the sequence
        //assigning the first element to a variable to be compared
        int minimum = sequence[0];

        //for loop for finding the minimum
        for (int i=1;i<=size-1;i++){

            if (sequence[i]<=minimum){
                minimum=sequence[i];
            }
        }
        //printing out the minimum number
        System.out.println("The Minimum number in the sequence is : " +minimum);

    }

}
