// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        // Implement your solution here
        // N is the maximum possible number in two Arrays 

        // It records the number of semiprime in [1, i]
        int[] record = new int[N + 1];
        // get the prime in [1, N/2] in order to calculate the record[]
        int[] isPrime = new int[N/2 + 1]; // 0 is prime, 1 is not. 

        int l = N / 2 + 1;
        int i = 2;
        while( i * i < l) {
            if (isPrime[i] == 0) {
                int k = i * i;
                while( k < l ) {
                    isPrime[k] = 1;
                    k += i;
                }
            }
            i += 1;
        }
        // System.out.println(Arrays.toString(isPrime));
        // Calculate the records 
        for (i = 2; i <l; i++ ) {
            if (isPrime[i] == 0) {
                for (int j = i; j <l ; j ++) {
                    if (isPrime[j] == 0 && i * j < N + 1) {
                        record[i * j] = 1;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(record));
        // Calculate the sum of records
        int sum = 0;
        int[] sums = new int[N + 1];
        for (i = 2; i < N+1; i++) {
            if (record[i] == 1) {
                sum += 1;
            }
            sums[i] = sum;
        }
        // System.out.println(Arrays.toString(sums));
        // Calculate the result
        int[] res = new int[P.length];
        for (i = 0; i< P.length; i++) {
            // System.out.println("" + sums[Q[i]] + "-" + sums[P[i] -1]);
            res[i] = sums[Q[i]] - sums[P[i] -1];
        }
        return res;
    }
}