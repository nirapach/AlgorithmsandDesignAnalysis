import java.util.Scanner;

/**
 * Created by Niranjan on 9/3/2015.
 */
public class SortingLab2 {


    public static boolean BubbleSortAlgorithm(int[] sequence, int size) {

        boolean result = false;
        //bubble sort algorithm

        try {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < size - 1 - j; i++) {
                    if (sequence[i] > sequence[i + 1]) {
                        int temp = sequence[i];
                        sequence[i] = sequence[i + 1];
                        sequence[i + 1] = temp;
                    }
                }
            }
            result = true;
        } catch (Exception e) {
            System.out.println("Exception while sorting using Bubble sort");
        }

        return result;
    }

    public static boolean InsertionSortAlgorithm(int[] sequence, int size) {

        boolean result = false;
        //Insertion sort algorithm

        try {

            int hold;/* get the element to be sorted( seeking a right place to place it)*/
            for(int i=1;i<size;i++){
                hold=sequence[i];
                int j;
                /*****find a position to insert that element*****/
                /* if the current element, that is array[j-1] is larger than "hold", then move array[j-1] backward*/
                /*leaving the position for "hold" or the element even smaller than "hold"*/
                /* if the current element array[j-1]is smaller than "hold", since the elements before array[j-1] are already sorted,*/
                /*just stop, since "hold" is already in the right place*/
                /*repeat this process*/
                for(j=i-1;j>=0 && hold<sequence[j];j--){
                    sequence[j+1]=sequence[j];
                     }
                sequence[j+1]=hold;
            }
            result = true;
        } catch (Exception e) {
            System.out.println("Exception while sorting using Insertion sort");
        }

        return result;
    }

    public static boolean MergeSortAlgorithm(int[] sequence, int left,int middle_one,int right) {

        boolean result = false;
        //merge sort algorithm

        try {

            int[] hold=new int[50];
            int i,left_last,number_of_elements,temp;

            left_last = (middle_one - 1);
            temp = left;
            number_of_elements = (right - left + 1);

            while ((left <= left_last) && (middle_one <= right))
            {
                if (sequence[left] <= sequence[middle_one])
                    hold[temp++] = sequence[left++];
                else
                    hold[temp++] = sequence[middle_one++];
            }

            while (left <= left_last)
                hold[temp++] = sequence[left++];

            while (middle_one <= right)
                hold[temp++] = sequence[middle_one++];

            for (i = 0; i < number_of_elements; i++)
            {
                sequence[right] = hold[right];
                right--;
            }

            result = true;
        } catch (Exception e) {
            System.out.println("Exception while sorting using Merge sort");
        }

        return result;
    }

    public static boolean RunBubbleSort(int[] sequence,int size) {
        boolean sort_success = false;


        //calling the bubble sort sequence
        boolean success = BubbleSortAlgorithm(sequence, size);
        //printing out the sorted bubble sort
        System.out.println("The Sorted sequence using Bubble Sort is: ");

        if (success) {
            for (int i = 0; i <= size - 1; i++) {
                System.out.println(sequence[i]);
            }
            sort_success = true;
        }
        return sort_success;

    }

    public static boolean RunInsertionSort(int[] sequence,int size) {
        boolean sort_success = false;


        //calling the Insertion sort sequence
        boolean success = InsertionSortAlgorithm(sequence, size);
        //printing out the sorted array
        System.out.println("The Sorted sequence using Insertion Sort is: ");

        if (success) {
            for (int i = 0; i <= size - 1; i++) {
                System.out.println(sequence[i]);
            }
            sort_success = true;
        }
        return sort_success;

    }

    public static void PrintMergeSort(int[] sequence,int size) {

        //printing out the sorted array using merge sort
        System.out.println("The Sorted sequence using Merge Sort is: ");

            for (int i = 0; i <= size - 1; i++) {
                System.out.println(sequence[i]);

        }

    }
    public static boolean RunMergeSort(int[] sequence,int left,int right) {
        boolean sort_success = false;

        //calling the merge sort sequence
        int middle;
        //recursively calling the array to split and merge
        if(right>left){
            middle=(right+left)/2;
            RunMergeSort(sequence,left,middle);
            RunMergeSort(sequence,(middle+1),right);

            //calling the subroutine to merge the two sorted array's
            MergeSortAlgorithm(sequence,left,(middle+1),right);
            sort_success=true;
        }

        return sort_success;

    }

    public static void main(String args[]) {

        //header
        System.out.println("Program for sorting the array using bubble sort");
        System.out.println("-----------------------------------------------------");

        //Initialize the scanner class to get the input
        Scanner in = new Scanner(System.in);

        //get the input for the size of the sequence
        System.out.println("Please Enter the Size of the Array (i.e.,) the number of individual" +
                " numbers that are present in the array..");
        int size = in.nextInt();

        //initialize the array with the size of the sequence
        int sequence[] = new int[size];

        //storing the input into the array
        for (int i = 0; i <= size - 1; i++) {
            System.out.println("Enter the number that needs to be added to the array ...");
            sequence[i] = in.nextInt();
        }

        System.out.println("Choose from the Following options to perform the sorting algorithms");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Merge Sort");
        int choice=in.nextInt();

        switch(choice) {

            case 1:
            //call the bubble sort algorithm
                RunBubbleSort(sequence, size);
                break;
            case 2:
                RunInsertionSort(sequence,size);
                break;
            case 3:
                boolean merge_success=RunMergeSort(sequence,0,size-1);
                if(merge_success){
                    PrintMergeSort(sequence,size);
                }
                break;
            default:
                System.out.println("Please enter a valid choice");
                break;
        }

    }
}
