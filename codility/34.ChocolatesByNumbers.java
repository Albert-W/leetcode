// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
// O(N + M)
class Solution {
    public int solution(int N, int M) {
        public int solution(int N, int M) {
            // Implement your solution here
            // N * gcd (N, M) is the minimum number which % m == 0; 
            return N / gcd(N, M);
        }

        public int gcd(int N, int M) {
            if (M == 0) {
                return N;
            }
            return gcd(M, N%M);
        }
    }


    // O(N + M)
    public int solution_TE(int N, int M) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (! set.contains(i)) {
            set.add(i);
            i = (i + M) % N;
        }
        return set.size();
    }
}