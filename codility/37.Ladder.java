// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int[] B) {
        // Implement your solution here
        int[] res = new int[A.length];
        int[] record = climb(50000); // don't call it in the loop! 
        for (int i = 0;i<A.length;i++) {
            res[i] = record[A[i]] % (int)Math.pow(2, B[i]);
        }
        return res;
    }

    public int[] climb(int N) {
        // Return the number of ways to climb N rungs; 
        int[] record = new int[N + 1];
        record[0] = 0;
        record[1] = 1;
        record[2] = 2;
        // N % 4 doesn't change the resoult of N % 2; 
        // % 2^30 deosn't change the result of % 2^B[i];
        for (int i = 3; i<=N; i++) {
            record[i] = (record[i -1] + record[i - 2]) % (int)Math.pow(2, 30);
        }
        return record;
    } 
}