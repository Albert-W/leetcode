public class MaxSliceSum {
    
}
// 最大子串和 O(n)
// Codility
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        // 不允许空 为子集
        int maxSum = A[0];
        int currentSum = A[0];
        for(int i = 1;i<A.length;i++){
            // 如果允许空串
            // if(currentSum < 0){
            //     currentSum = 0;
            // } 
            // currentSum += A[i];
            // 如果不允许空串，负值也要计算其中
            if(currentSum <0){
                currentSum = A[i];
            } else {
                currentSum += A[i];
            }
                
            if(currentSum > maxSum ){
                maxSum = currentSum;
            }
        }
        return maxSum; 
    }
}