import java.util.ArrayList;
import java.util.List;

public class ChocolatesByNumber {
    
}


class Solution {

    // 使用GCD
    // O(log(N + M))
    public int solution(int N, int M) {
        return N/gcd(N,M);
    }

    private int gcd(int N, int M){
        if(M == 0){
            return N;
        } else {
            return gcd(M, N%M);
        }
    }


    // 换Array 为 ArrayList;
    // TIMEOUT ERROR, Killed
    public int solution(int N, int M) {
        // write your code in Java SE 8
        List<Integer> memo = new ArrayList<>();
        int sum = 0;
        
        int i = 0;
        while( !memo.contains(i) ){
            memo.add(i);
            sum += 1;
            i = (i+ M)%N;
        }
        return sum;
    }    


    // OutOfMemoryError: Java heap space
    public int solution_m(int N, int M) {
        // write your code in Java SE 8
        int[] memo = new int[N];
        int sum = 0;
        
        int i = 0;
        while( memo[i] == 0){
            memo[i] = 1;
            sum += 1;
            i = (i+ M)%N;
        }
        return sum;
    }
}