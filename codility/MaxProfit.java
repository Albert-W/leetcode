public class MaxProfit {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length < 2){
            return 0;
        }
        int min = A[0];
        int profit  =0;
        for(int i = 1;i<A.length;i++){
            if(A[i] < min){
                min = A[i];
            } else {
                profit = Math.max(A[i]-min, profit);
            }
        }
        return profit;
    }
}