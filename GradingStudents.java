import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
    List<Integer> res = new ArrayList<>();
    for(int i = 0 ; i< grades.size(); i++){
        int grade = grades.get(i);
        /* If diff between is greater than 3 theres no need to round up
        eg Nearest next multiple is 45 
        41 % 5 = 1   45-41 = 4    diff which is greater than 3   
        42 % 5 = 2   45-42 = 3     not less than 3
        43 % 5 = 3   45-43 = 2      less than 3    round up
        44 % 5 = 4   45-44 = 1      less than 3    round up
        45 % 5 = 5   45-45 = 0     less than 3    round up
        
        If modulus ans is less than 3 then only round up as there diff for sure will be less than 3 ie 0,1,2 
        To round up
        we just have to add grade to (diff of 5 and grade % 5)
        Eg
         44  we just have to add 1 to make it 45
         to get 1  ----->  5 - 44%5 = 5-4=1
         
        */
        int ans = grade < 38 || grade % 5 < 3 ? grade : grade + (5 - grade % 5);
        res.add(ans);
    }
    return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
