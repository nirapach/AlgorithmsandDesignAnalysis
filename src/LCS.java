import java.util.Scanner;

/**
 * Created by Niranjan on 10/23/2015.
 */
public class LCS {

    public static void process_Strings(String a, String b){
        //length of strings
        int f=a.length();
        int s =b.length();
        // cache array
        int[][] cache=new int[f][s];
        // directions array
        int[][] directions= new int[f][s];

        String[] one = new String[f];
        String[] two= new String[s];
        for(int i=0;i<f;i++){
            one[i]=Character.toString(a.charAt(i));
        }
        for(int j=0;j<s;j++){
            two[j]=Character.toString(b.charAt(j));
        }

        //initialize the array's
        for(int i=0;i<f;i++){
            for(int j=0;j<s;j++) {
                cache[i][j] = -1;
                directions[i][j] = -1;
            }
        }
        //calling the dynamic programming algo
        int length_of_longest_string=LCS_algo(one,two,f-1,s-1,cache,directions);

        System.out.println("Length of largest common subsequence:"+length_of_longest_string);
        System.out.println("The longest common substring in reverse order : ");

        print_path(one,two,f-1,s-1,directions);

    }
    public static int LCS_algo(String[] a,String[] b,int p, int q, int[][] cache, int[][] directions){

        if (p<0 || q<0){
            return 0;
        }
        if(cache[p][q]!=-1){
            return cache[p][q];
        }
        else {
            if (a[p].equals(b[q])){
                directions[p][q] = 0;
                return cache[p][q] = 1 + LCS_algo(a, b, p - 1, q - 1, cache, directions);
            } else {
                int v1 = LCS_algo(a, b, p - 1, q, cache, directions);
                int v2 = LCS_algo(a, b, p, q - 1, cache, directions);
                if (v1 > v2) {
                    directions[p][q] = 1;
                    return cache[p][q] = v1;
                } else {
                    directions[p][q] = 2;
                    return cache[p][q] = v2;
                }
            }
        }

    }
    public static void print_path(String[] a, String[] b,int p, int q,int[][] directions) {

           if(p<0 || q < 0){
                System.out.println();
           }
        else {
               if (directions[p][q] == 0) {
                   System.out.println(a[p]);
                   print_path(a, b, p - 1, q - 1, directions);
               } else if (directions[p][q] == 1) {
                   print_path(a, b, p - 1, q, directions);
               } else if (directions[p][q] == 2) {
                   print_path(a, b, p, q - 1, directions);
               }
           }

    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("B609 Algos Lab 9....LCS PROGRAM\n");
        String first, second;
        /* Accept input strings */
        System.out.println("Enter the first string......");
        first = scan.nextLine();
        System.out.println("Enter the second string......");
        second = scan.nextLine();
        //call LCS
        process_Strings(first,second);


    }

}
