import java.util.Scanner;

/**
 * Created by Niranjan on 9/17/2015.
 */
public class QuickSort {

    public static int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    public static void QuickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            QuickSort(arr, left, index - 1);
        if (index < right)
            QuickSort(arr, index, right);
    }


    //main function
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("B609 Algos Lab 4....QUICK SORT PROGRAM\n");
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
        int low=0;
        int high = arr.length-1;
        /* Call method sort */
        QuickSort(arr,low,high);
        /* Print sorted Array */
        System.out.println("\nElements after sorting by Quick Sort ");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            System.out.print("\n");
        }
        System.out.println();
    }


}

