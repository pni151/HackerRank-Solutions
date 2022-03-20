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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
    int highestScoreCount = 0; 
    int lowestScoreCount = 0;
    ArrayList<Integer> answer= new ArrayList<>(); 
    int highestScore = scores.get(0); 
    int lowestScore = scores.get(0);
    /*if the score is less than min score update it
    if the score is greater than max score updateit and count it*/
    for (int i=1;i< scores.size(); i++){ //started from because we have already updated the min nd max to 1st element
        if(scores.get (i) > highestScore) { 
            highestScore = scores.get(i); 
            highestScoreCount++;
            }
        if(scores.get(i) < lowestScore) {
            lowestScore = scores.get(i);
            lowestScoreCount++;
            }
    }
    //add the values to list
    answer.add (highestScoreCount); 
    answer.add(lowestScoreCount);
    return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
