import java.util.Scanner;

/**
 * Created by Niranjan on 9/25/2015.
 */
public class BubbleSort {

    public static void bubble_sort(int arr[])
    {
        int size= arr.length;
        int j;
        for(int k=size;k>=0;k--){
            for(int i=0;i<size-1;i++){
                j=i+1;
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }

    }
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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

        /* Call method sort */
        bubble_sort(arr);
        /* Print sorted Array */
        System.out.println("\nElements after sorting by Bubble Sort ");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            System.out.print("\n");
        }
        System.out.println();
    }


}
