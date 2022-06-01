import java.io.*;
import java.util.*;
import java.math.BigInteger;  
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        //input bigInteger
        BigInteger a = in.nextBigInteger(); 
        BigInteger b = in.nextBigInteger(); 
        //it has built functions add and multiply
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
