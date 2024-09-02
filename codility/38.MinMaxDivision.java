// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// O(N*log(N+M))
class Solution {
    public int solution(int K, int M, int[] A) {
        // It's hard to implement a division.
        // but it's easy to check if the division is valid.
        int sum = 0;
        int max = 0;
        for (int a: A) {
            sum += a;
            max = Math.max(max, a);
        }
        // int mid = (sum + max) / 2;
        int res = 0;
        while (max <= sum) {  // !!! The equal sign 
            int mid = (sum + max) / 2;
            // if it's valid - There are still buffer to divide, try smaller; 
            // if it's invalid - There are not enough buffer to divide, try larger;
            if (isValid(mid, K, A)) {
                res = mid;
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }
        return res;
    }

    public boolean isValid(int sum, int K, int[] A) {
        // System.out.println("sum is: " + sum);
        int partSum = 0;
        int count = 0;
        for (int a: A) {
            partSum += a;
            // System.out.println(partSum);
            if (partSum > sum) {
                count += 1;
                partSum = a;
                
            } else if (partSum == sum) {
                count += 1;
                partSum = 0;
            } 
        }
        if (partSum > 0) {
            return count + 1 <= K;
        } else {
            return count <= K;
        }
        
    }
}