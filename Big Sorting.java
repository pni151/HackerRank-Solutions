import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
        //use comparator to compare
        Collections.sort(unsorted, new Comparator<String>(){
            public int compare(String a, String b){
                //sort on basis of length
                if(a.length() > b.length()) return 1; 
                else if(a.length() < b.length()) return -1;
                //if length equal .. convert to Integer and then compare
                else{
                    BigInteger b1 = new BigInteger (a);
                    BigInteger b2 = new BigInteger (b);
                    return b1.compareTo(b2); //1 -1 0
                }
            }
        });

        return unsorted;
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String unsortedItem = bufferedReader.readLine();
            unsorted.add(unsortedItem);
        }

        List<String> result = Result.bigSorting(unsorted);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
