// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        // A[0] < 0, A[-1] > 0;

        int min = 0;
        int max = A.length - 1;
        int res = Math.abs(A[min] + A[max]);
        while ( min <= max) {
            int temp = A[min] + A[max]; // Try to find 0 or the closest to 0
            res = Math.min(res, Math.abs(temp));
            if ( temp > 0) {
                max -= 1;
            } else if (temp == 0) {
                return 0;
            } else {
                min += 1;
            }
        }
        return res;
    }

}