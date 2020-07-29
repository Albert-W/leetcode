import java.util.*;
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        
        // int[] A = {0, 10, -5, -2, 0};
        int[] A = {3, 2, 6, -1, 4,5,-1,2};
        int s = new Solution().solution(A);
        System.out.println(s);
    }
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // 以i为中心，分为两段。 
        // 分别求[0, i-1]的最大子段和
        // 求[i+1，A.length -1] 的最大子段和
        // 最大子段和与 顺序无关， 与子段的元素有关。
        int[] leftSum = new int[A.length+1];
        // 第一个位置留给Start
        for(int i = 1;i< A.length;i++){
            leftSum[i+1] = Math.max(0, leftSum[i] + A[i]);
        }
        System.out.println(Arrays.toString(leftSum));
        
        int[] rightSum = new int[A.length + 1];
        // 最后一个位置留给End, 
        // 可以为空，与 不可为空的写法不同。
        for(int j = A.length-2 ;j>0;j--){
            rightSum[j-1] = Math.max(0, rightSum[j] + A[j]);
        }
        System.out.println(Arrays.toString(rightSum));
        
        int maxSum = 0;
        for(int k = 1;k<A.length -1;k++){
            maxSum = Math.max(maxSum, leftSum[k] + rightSum[k]);
        }
        return maxSum;
        
    }
}