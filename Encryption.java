import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        s = s.replaceAll("\\s", ""); //all spaces removed
        //get the row and column size as asked
        int rowSize = (int)Math.floor(Math.sqrt(s.length()));
        int colSize = (int)Math.ceil(Math.sqrt(s.length()));
        
        String t = "";
        /* The difference between each value in encrypted ans is the ceil value ie colSize*/
        for(int i = 0; i< colSize;i++){
            //s.length as we are increasing the indexs
            for(int j = 0; j<s.length();j++){
                //to avoid any error or exception we always check is sum is less than s.length
                if(i+j<s.length()){
                    //i+j as we are using matrix like solution
                    t = t + s.charAt(i+j);
                    //increae by colSize
                    //-1 as in the loop itself j is getting increased by 1
                    j = j+ colSize - 1;
                }
            }
            t = t+ " "; //to add space after each word in outer loop
        }
    return t; //return the string
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
