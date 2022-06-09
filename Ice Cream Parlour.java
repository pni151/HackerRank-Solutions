import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        //same as two sum problem
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            int y = m - x;
            Integer j = map.get(y);
            if (j != null) {
                result[0] = j + 1;
                result[1] = i + 1;
                break;
            }
            map.put(x, i);

        }
        //array to list
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i<result.length; i++){
            ans.add(result[i]);
        }
        return ans;
    // }
    //     Collections.sort(arr);
    //     int start = 0, end = arr.size()-1;
        
    //     while(start<end){
    //         if(arr.get(start)+ arr.get(end) == m){
    //                 ans.add(start+1);
    //                 ans.add(end+1);
    //             }
    //         else if(arr.get(start)+ arr.get(end) > m){
    //             end--;
    //         }
    //         else{
    //             start++;
    //         }
            
    //     }
            
    // return ans;
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int m = Integer.parseInt(bufferedReader.readLine().trim());

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            List<Integer> result = Result.icecreamParlor(m, arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
