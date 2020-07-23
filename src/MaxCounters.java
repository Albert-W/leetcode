/*
Codility Lesson 4
Counting Elements 
*/
import java.util.Arrays;

public class MaxCounters {
    
    
}
class Solution {
    // 记录最低值，最后一次性赋值。
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int min = 0;
        int max = 0;
        int[] memo = new int[N];
        for(int i: A){
            if(i <= N){
                memo[i-1] = Math.max(min,memo[i-1])+ 1;
                if(memo[i-1] > max){
                    max = memo[i-1];
                }
            } else {
                min = max;
            }
        }
        // 用以替换For内部循环的fill操作。 
        for(int i=0;i<N;i++){
            if(memo[i]< min){
                memo[i] = min;
            }
        }
        return memo;
    }


    // 使用fill 
    // 超时
    public int[] solution_t(int N, int[] A) {
        // write your code in Java SE 8
        int max = 0;
        int[] memo = new int[N];
        for(int i: A){
            if(i <= N){
                memo[i-1] += 1;
                if(memo[i-1] > max){
                    max = memo[i-1];
                }
            } else {
                Arrays.fill(memo,max);
            }
        }
        return memo;
    }
}
