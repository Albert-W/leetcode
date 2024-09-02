// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        if (A.length < 2) {
            return A.length;
        }
        int res = 0;
        int min = 0;
        int max = A.length -1;
        
        if (A[0] == Integer.MIN_VALUE) {
            res = 1;
            min = 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = min; i< A.length; i++) {
            int abs = Math.abs(A[i]);
            if (!set.contains(abs)) {
                res += 1;
                set.add(Math.abs(abs));
            }
        }
        return res;
    }
}