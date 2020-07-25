public class PassingCars {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] memo = new int[A.length+1];
        for(int i=A.length-1;i>=0;i--){
            memo[i] = memo[i+1] + A[i];
        }
        int sum = 0;
        for(int j=0;j<A.length;j++){
            if(A[j] == 0){
                sum+=memo[j];
                if(sum> 1000000000){
                    return -1;
                }
            }
        }
        return sum;
    }
}