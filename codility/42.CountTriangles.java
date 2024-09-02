// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here 
        Arrays.sort(A);
        // System.out.println(Arrays.toString(A));
        int res = 0;
        for (int i = 0; i <= A.length -3; i ++) {
            int j = i + 1; // the second element
            int k = j + 1; // the third element
            while(j <= A.length -2) {
                if (k < A.length && A[i] + A[j] > A[k]) {
                    // System.out.printf("%d %d %d \n", i, j,k);
                    
                    k += 1; // increment the 3rd element
                } else {
                    res += k - 1 - j; // for each j, there are k - 1 - j triangles
                    j += 1;
                }
            }
        }
        return res;

    }
}