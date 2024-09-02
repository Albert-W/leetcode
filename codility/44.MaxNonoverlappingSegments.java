// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        
        if (A.length < 2) {
            return A.length;
        }
        int res = 1;
        int pos = 0;
        for (int i = 1; i<A.length; i++ ) {
            // Because B is sorted, took i, doesn't effect segments behind i; 
            if (A[i] > B[pos]) {
                res += 1;
                pos = i;
            } 
        }
        return res;
    }
}