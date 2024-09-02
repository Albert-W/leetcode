// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
//  ([2], [2], [1])

class Solution {
    public int solution(int[] A, int[]B, int[]C) {
        // Implement your solution here 
        // For each plank, check the minimum index of nail, if not found, return -1;
        // Each around get the current result;
        int[][] nails = new int[C.length][2];
        for (int i = 0; i< C.length; i++) {
            nails[i][0] = C[i];
            nails[i][1] = i;
        }
        Arrays.sort(nails, (a, b) -> (a[0] - b[0]));
        // System.out.println(Arrays.deepToString(nails));

        // res -  will be the largest required index of nails;
        int res = 0;
        for (int i = 0; i< A.length; i++) {
            res = find_min_index(A[i], B[i], nails, res);
            if (res ==-1 ) {
                return -1;
            }
        }
        return res + 1;
    }

    public int find_min_index(int a, int b, int[][] nails, int lastIndex) {
        // System.out.printf("-----a:%d -- b:%d ---\n", a, b);
        int left = 0;
        int right = nails.length - 1;
        int min = -1
        // Find one nail which is valid; 
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nails[mid][0] >= a && nails[mid][0] <= b) {
                // System.out.printf("nail:%d---left:%d---right:%d\n", nails[mid][1], left, right);
                min = mid;
                right = mid - 1; // Make sure it will the the smallest nails[mid][0]
            } else if (nails[mid][0] < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } 
        // Incase of index out of range;
        if (min == -1) {
            return -1;
        }

        // Start from min find the minimal index 
        int res = nails[min][1];
        for (int i = min; i < nails.length; i++) {
            if (nails[i][0] > b) {
                break;
            }
            if (nails[i][1] <= lastIndex) {
                return lastIndex;
            }
            res = Math.min(res, nails[i][1]);
        }
        return res;
    }
}
    // 75%
    public int solution_TE(int[] A, int[]B, int[]C) {
        // Implement your solution here 
        // For each plank, check the minimum index of nail, if not found, return -1;
        // Get a list of index, return the maximum index; 
        int[][] nails = new int[C.length][2];
        for (int i = 0; i< C.length; i++) {
            nails[i][0] = C[i];
            nails[i][1] = i;
        }
        Arrays.sort(nails, (a, b) -> (a[0] - b[0]));
        // System.out.println(Arrays.deepToString(nails));
        int[] record = new int[A.length];
        for (int i = 0; i< A.length; i++) {
            record[i] = find_min_index(A[i], B[i], nails);
            if (record[i] == nails.length) {
                return -1;
            }
        }

        int res = 0;
        // System.out.println(Arrays.toString(record));
        for (int i = 0; i< A.length; i++) {
            res = Math.max(res, record[i]);
        }
        return res + 1;

    }

    public int find_min_index(int a, int b, int[][] nails) {
        // System.out.printf("-----a:%d -- b:%d ---\n", a, b);
        int left = 0;
        int right = nails.length - 1;
        int min = nails.length;
        // Find one nail which is valid; 
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nails[mid][0] >= a && nails[mid][0] <= b) {
                // System.out.printf("nail:%d---left:%d---right:%d\n", nails[mid][1], left, right);
                min = mid;
                right = mid - 1; // Make sure it will the the smallest nails[mid][0]
            } else if (nails[mid][0] < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } 
        // Incase of index out of range;
        if (min == nails.length) {
            return nails.length;
        }

        // Start from min find the minimal index 
        int res = nails[min][1];
        for (int i = min; i < nails.length; i++) {
            if (nails[i][0] > b) {
                break;
            }
            res = Math.min(res, nails[i][1]);
        }
        return res;
    }
}

    public int solution_TE(int[] A, int[] B, int[] C) {
        // Implement your solution here 
        // Sort the planks and nails;
        int[][] plank = new int[A.length][2];
        for (int i = 0; i< A.length; i++) {
            plank[i][0] = A[i];
            plank[i][1] = B[i];
        }
        Arrays.sort(plank, (a, b) -> (a[0] - b[0]));

        // Arrays.sort(C);
        int i = 0;
        int j = 0; // it's the nails in C; 
        HashSet<Integer> set = new HashSet<>(); // The nails before j; 
        while( i < A.length && j < C.length) {
            set.add(C[j]);
            // C[j] in the early would be a big number; which is useful to nail the later planks;
            if (isValid(plank[i][0], plank[i][1], set)) {
                i += 1;
                // System.out.println(j);
                if (i == A.length) {
                    // System.out.printf("%d : %d : %d : % d\n", plank[i][0],plank[i][1],j,C[j]);
                    return j + 1;
                }
            } else {
                j += 1;
            }
        }


        return -1;
    }
    public boolean isValid(int a, int b, Set<Integer> set) {
    for (int s: set) {
        if (s >= a && s <= b) {
            return true;
        }
    }
    return false;
}
}