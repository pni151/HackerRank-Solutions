import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    
    //first go from left to right and place greedly the values
    //then using those go from right to left , now compare both list and array and give values accordingly
    //return long sum
    public static long candies(int n, List<Integer> arr) {
        int[] candi = new int[arr.size()];
        candi[0] = 1;
        
        //left to right place at 0th index 1
        for (int i = 1; i < arr.size(); i++) {
            //if i+1 is greater then add 1 to ith candi
            if (arr.get(i-1) < arr.get(i)) {
                candi[i] = candi[i-1] + 1;
            }
            
            //else set it to 1, as we dont know how much less values will be there
            if (arr.get(i-1) >= arr.get(i)) {
                candi[i] = 1;
            }
        }
        //now iterate from right to left
        //check if for both and add 1 accordingly
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i+1) < arr.get(i)) {
                if (candi[i] <= candi[i+1]) {
                    candi[i] = candi[i+1] + 1;
                }
            }
        }
        // declare sum and calculate ir
        long sum = 0;
        for (int i = 0; i < candi.length; i++) {
            sum += candi[i];
        }

        return sum;//return sum as answer
    }

    // Write your code here

    }


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        long result = Result.candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
 
