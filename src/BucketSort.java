import java.util.Scanner;

/**
 * Created by Niranjan on 9/25/2015.
 */
public class BucketSort {

    public static int[] bucket_sort(int arr[],int maximum_value)
    {
        int[] sorted_sequence = new int[arr.length];

        int[] Bucket = new int[maximum_value + 1];

        for (int i = 0; i < arr.length; i++)
            Bucket[arr[i]]++;

        int k= 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[k++] = i;

        return sorted_sequence;

    }

    static int maxValue(int[] sequence)
    {
        int maxValue = 0;
        for (int i = 0; i < sequence.length; i++)
            if (sequence[i] > maxValue)
                maxValue = sequence[i];
        return maxValue;
    }
    //main function
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("B609 Algos Lab 4....BUBBLE SORT PROGRAM\n");
        int n, i;
        /* Accept number of elements */
        System.out.println("Enter size of the elements that should be sorted");
        n = scan.nextInt();
        /* Make array of n elements */
        int arr[] = new int[ n ];
        /* Accept elements */
        System.out.println("\nEnter "+ n +" individual elements");
        for (i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int maximum_value=maxValue(arr);
        /* Call method sort */
        int[] sorted_sequence=bucket_sort(arr,maximum_value);
        /* Print sorted Array */
        System.out.println("\nElements after sorting by Bubble Sort ");
        for (i = 0; i < sorted_sequence.length; i++) {
            System.out.print(sorted_sequence[i] + " ");
            System.out.print("\n");
        }
        System.out.println();
    }


}
