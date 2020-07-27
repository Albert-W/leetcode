import java.util.*;
public class CountDistinctSlices {
    public static void main(String[] args) {
        
        String s = "hellol";
        s = s.replace("l", "n");
        
        System.out.println(s);
    }
}


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int M, int[] A) {
        // write your code in Java SE 8
        int sum = 0;
        Map<Integer, Integer> memo = new HashMap<>();

        
        int left = -1;
        // 每一轮 只 加自己的有效值。 
        for(int i = 0;i<A.length;i++){
            // not found 
            int lastOccur = memo.containsKey(A[i])? memo.get(A[i]):-1;
            // 排除掉之前的重复出现值； 
            left = Math.max(left, lastOccur);
            sum += i - left;
            memo.put(A[i], i);
            if (sum >= 1000000000) {
                return 1000000000;
            }
        }
        return sum;
    }
}