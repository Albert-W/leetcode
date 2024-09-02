// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
class Solution {
    public int solution(int M, int[] A) {
        int[] isVisited = new int[M + 1];
        int i = 0;
        int j = 0;
        int result = 0;
        while(i < A.length && j < A.length) {
            // Check if A[j] is already visited - if no, mark it as visited and increment j
            // If yes, mark A[i] as not visited and increment i
            if (isVisited[A[j]] == 0) {
                result += (j - i + 1); // for each j, there are j - i + 1 slices
                if (result >= 1000000000) {
                    return 1000000000;
                }
                isVisited[A[j]] = 1;
                j += 1;
            } else {
                // It will not increment the result util the duplicate is removed, which is equal to A[j]
                isVisited[A[i]] = 0;
                i += 1;
            }
        }
        return result;
    }
}


// 705
class Solution_TE {
    // It doesn't use the M information
    public int solution(int M, int[] A) {
        // Implement your solution here
        int res = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i< A.length; i++) {
            set.clear();
            int j = i;
            while(j < A.length) {
                // System.out.println(A[j]);
                if (set.contains(A[j])) {
                    set.clear();
                    break;
                } else {
                    set.add(A[j]);
                    res += 1;
                    // System.out.printf("%d --- %d\n", i,j);
                }
                j +=1;
                
            }
        }
        return res;
    }
}