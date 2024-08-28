// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// Instead of loop each position, check if it's in the set of steps. 
// Loop each position and steps, check if it reaches the end.
class Solution {
    public int solution(int[] A) {
        if (A.length < 2) {
            return 1;
        }
        int N = A.length; // the position N is the end; 
        // Always try if fog can jump to the end first. 
        
        Set<Integer> possible_position = new HashSet<>();
        possible_position.add(-1);
        Set<Integer> possible_steps = fib(A.length + 1);

        // int k = 0; // It's the steps required to go to N; 
        for (int k = 0; k<A.length; k++ ) {
            Set<Integer> next_possible_position = new HashSet<>();
            for (int p: possible_position) {
                for (int s: possible_steps) {
                    if (p + s == N) {
                        return k + 1;
                    }
                    if (p + s < N && A[p+s] == 1){
                        next_possible_position.add(p + s);
                    }
                }
            }
            possible_position = next_possible_position;
        }
        return -1;

    }


    // 25%
    public int solution_TE(int[] A) {
        // Implement your solution here
        if (A.length == 0) {
            return 1;
        }
        Set<Integer> set = fib(A.length);
        // System.out.println(set);
        int[] record = new int[A.length+1]; // It records how many steps required to go to index i;
        // Arrays.fill(record, A.length+1);

        for( int i = 0;i<A.length + 1;i++) {
            if ( i == A.length || A[i] != 0 ) {
                for (int j = 0; j < i; j ++) {
                    if(A[j]!=0 && record[j] != 0 && set.contains(i - j + 1)) {
                        
                        if (record[i] > 0 ) {
                            record[i] = Math.min(record[i], record[j] + 1);
                        } else {
                            record[i] = record[j] + 1;
                        }
                        System.out.printf("%d,%d,%d\n", i,j, record[i]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(record));
        return record[A.length] == A.length + 2? -1: record[A.length];
    }

    public Set<Integer> fib(int N) {
        Set<Integer> set = new HashSet<>();
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        set.add(1);
        for (int i = 2; i<=N; i++) {
            if (fib.get(i-1) + fib.get(i-2) > N) {
                break;
            } 
            fib.add(fib.get(i-1) + fib.get(i-2));
            set.add(fib.get(i));
        }
        return set;
    }
}