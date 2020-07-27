public class MaxNonOverlappingSegments {
    
}
class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int sum = 0;
        int min = -1;
        for(int i=0;i<A.length;i++){
            // 最早满足条件的，就是B[i] 最小的。
            if(A[i]> min){
                sum += 1;
                min = B[i];
            }
            
        }
        return sum;
    }
}