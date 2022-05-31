import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length()+ B.length());
        //compareTo function compares the strings
        System.out.println( A.compareTo(B)>0 ? "Yes" : "No");
        
        //First convert the 1st letter to capital using substring and toUppercase()
        String new_A=A.substring(0,1).toUpperCase();
        String new_B=B.substring(0,1).toUpperCase();
        //combine the capital letter and the remaining substring using +
        System.out.println(new_A+A.substring(1)+" "+new_B+B.substring(1));
        
    }
}



