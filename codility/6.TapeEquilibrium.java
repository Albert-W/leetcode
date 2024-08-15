public class TapeEquilibrium {
    
}
class Solution {
    // 使两边和最小
    public int solution(int[] A) {
        // write your code in Java SE 8
        int left = 0;
        // int sum = Arrays.stream(A).sum();
        int sum = 0;
        for(int i :A){
            sum+=i;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length-1;i++){
            left += A[i];
            int t = Math.abs( sum - 2 * left );
            if (t< min){
                min = t;
            }
        }
        return min;
    }
}