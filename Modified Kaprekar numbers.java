import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        //arraylist to store the result
        ArrayList<Long> al = new ArrayList<>();
        //iterate from p to q
        for(long i=p;i<=q;i++){
            //get the square 
            long sq = i*i;
            //convert it to string to ease the rest
            String num = String.valueOf(i);
            String s = String.valueOf(sq);
            //get leftlength ie total - plength
            int leftLength = s.length() - num.length();
            long leftNum = 0;
            //to avoid error for 0 check whether the length is 0
            if(leftLength == 0){
                leftNum = 0;
            }else{
                //otherwise get it by using substring, convert to long 
                leftNum = Long.parseLong(s.substring(0,leftLength));
            }
            //get the right num using substring
            long rightNum = Long.parseLong(s.substring(leftLength));
            
            //calculate the sum
            long sum = leftNum + rightNum;
            //check whether equal to i
            if(sum==i){
                //if so add it to the list
                al.add(i);
            }
        }
        //if size is 0 , print invalid
        if(al.size()==0){
            System.out.println("INVALID RANGE");
        }else{
            //otherwise print using for loop
            for(int i=0;i<al.size();i++){
                System.out.print(al.get(i)+" ");
            }
        }
    }
}

        
    // Write your code here


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
