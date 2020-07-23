public class FrogRiverOne {
    
}
class Solution {

    // 也可使用HashSet, 判断Set.size()==X

    // 统计有效叶片的次数
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int step = 0;
        boolean[] memo = new boolean[X];
        for(int t = 0;t<A.length;t++){
            if( !memo[A[t] -1] ){
                memo[A[t] -1] = true;
                step += 1;
                if(step == X){
                    return t;
                }
            }
        }
        return -1;
    }


    // 判断数组是否已经铺满。 
    // 超时
    public int solution_t(int X, int[] A) {
        // write your code in Java SE 8
        int[] memo = new int[X];
        int t = 0;
        for(;t<A.length;t++){
            memo[ A[t] - 1] = 1;
            if(isFull(memo)){
                return t;
            }       
        }
        return -1;
    }
    
    boolean isFull(int[] memo){
        for(int i: memo){
            if (i==0){
                return false;
            }
        }
        return true;
        
    }
}