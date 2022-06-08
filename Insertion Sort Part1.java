import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        int num, j;
        // Loop through the array
        for (int i = 1; i < n; i++) {
            //get num at index
            num = arr.get(i); 
            //get left elementto compare
            j = i - 1;
            
            // Perform shifting of elements when jth is greater than num
            while (j >= 0 && arr.get(j) > num) {
                arr.set(j+1, arr.get(j)) ;
                --j;
                // Print the array at every step
                for (int k = 0; k < n; k++)
                    System.out.print(arr.get(k) + " ") ;
                System.out.println();            
            }
            //finally insert the value
            arr.set(j+1, num) ;
        }
        // Print the final sorted array
        for (int k = 0; k < n; k++)
                System.out.print(arr.get(k) + " ") ;
                
    }
    // Write your code here

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
