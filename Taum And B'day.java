import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(long b, long w, long bc, long wc, long z) {
    // Write your code here
    long cost;
    //check whether cost of z + bc is less than wc 
    if (bc+z < wc){
        cost = b * bc + (bc+z) * w;
    }
    //check whether cost of z + wc is less than bc 
    else if (wc+z < bc){
        cost = w*wc + (wc+z) * b;
    }  
    //else calculate at actual cost
    else{
        cost = b * bc + wc * w;
    }
    
    return cost;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int b = Integer.parseInt(firstMultipleInput[0]);

            int w = Integer.parseInt(firstMultipleInput[1]);

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int bc = Integer.parseInt(secondMultipleInput[0]);

            int wc = Integer.parseInt(secondMultipleInput[1]);

            int z = Integer.parseInt(secondMultipleInput[2]);

            long result = Result.taumBday(b, w, bc, wc, z);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
