import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> arr) {
        int count=0;
        //create a mew array and copy list to it
        int[] a=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            a[i]=arr.get(i);
        }
        //sort that array
        Arrays.sort(a);
        
        //create array c of list size. to store index which are not in sorted order
        int[] c=new int[arr.size()];int j=0;
        
        //iterate over 2 arrays for equality
        //keep count to see whether swap is possible ie 2
        for(int i=0;i<arr.size();i++)
        {
            if(a[i]!=arr.get(i)){
                c[j]=i;j++;
                count++;
            }
        }

        int k=j,count1=0;
        if(count==2)
        {
            //print the index stored adding 1 as asked in ques
            System.out.println("yes");
            System.out.println("swap "+(c[0]+1)+" "+(c[1]+1));
        }
        else {
            //check whether reverse possible
            for(int i=0,l=k-1;(i<=k-1)&&(l>=0);i++,l--){
                if(arr.get(c[i])==a[c[l]]){
                    count1++;
                }
            }
            if(count1==j){
                System.out.println("yes");
                System.out.println("reverse "+(c[0]+1)+" "+(c[j-1]+1));
            }
            else
                System.out.println("no");
        }
    // Write your code here

    }
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

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
