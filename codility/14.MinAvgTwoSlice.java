public class MinAvgTwoSlice {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // 最小平均值只能发生了2元组，三元组之中。
        // 证明：取四元组 【a,b,c,d】， 
        // if a + b < c + d, then avg(a, b) < avg(a, b, c, d)
        // if a + b > c + d, then avg(c, d) < avg(a, b, c, d)
        // so min avg slice will always be slice of 2 or 3 elements.
    
        int[] memo = new int[A.length + 1];
        for(int i = 0;i<A.length;i++){
            memo[i+1] = memo[i] + A[i];
        }
        // 考虑到负数，需要取常量
        double min = Integer.MAX_VALUE;
        int index = 0;
        // 循环到最后一个二元组。
        for(int i = 0;i<A.length-1;i++){
            for(int j = 1;j<3 && i+j < A.length;j++){
                if( 1.0 * (memo[i+j+1] - memo[i])/(j+1) < min ){
                    min = 1.0 * (memo[i+j+1] - memo[i])/(j+1);
                    // break;
                    // 不可放到循环体外，只有满足条件才能执行
                    index = i;
                }
            }
        }
        return index;
    }

    //超时
    public int solution_e(int[] A) {
        // write your code in Java SE 8
        int[] memo = new int[A.length + 1];
        for(int i = 0;i<A.length;i++){
            memo[i+1] = memo[i] + A[i];
        }
        // 考虑到负数，需要取常量
        double min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0;i<A.length;i++){
            for(int j = i+1;j<A.length;j++){
                if( 1.0 * (memo[j+1] - memo[i])/(j+1-i) < min ){
                    min = 1.0 * (memo[j+1] - memo[i])/(j+1-i);
                    // break;
                    // 不可放到循环体外，只有满足条件才能执行
                    index = i;
                }
                
            }
        }
        return index;



    }
}