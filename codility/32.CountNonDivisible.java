// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// O(N * log(N))  0.540 sOK
class Solution {
    public int[] solution(int[] A) {
        // Implement your solution here
        int n = A.length; 
        int[] frequency = new int[2 * n + 1];
        for (int a: A) {
            frequency[a] += 1;
        }

        int[] res = new int[n];

        // Loop A get the result in res[]
        for (int i =0; i<n; i++) {
            int count = n;
            int j = 1;
            for (; j < Math.sqrt(A[i]) ; j++) {
                if (A[i] % j == 0) {
                    count -= frequency[j];
                    count -= frequency[A[i] / j];
                }
            }
            if (j * j == A[i]) {
                count -= frequency[j];
            }

            res[i] = count;

        }

        return res;
    }

    
}
