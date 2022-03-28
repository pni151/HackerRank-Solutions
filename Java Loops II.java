import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt(); //no of testcases
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
        
        int sum = a ; //because we are adding a  everytime
        for(int j = 0; j< n ; j++ ){
            sum += b * Math.pow(2, j); //as the cases are redundant we just add new result to prev one
            
            System.out.print(sum + " ");
        }
        System.out.println();
        }
        in.close();
    }
}
