import java.util.Arrays;

public class Triangle {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // 排序后，只需要小边之和大于长边
        int[] B = A.clone();
        Arrays.sort(B);
        for(int i=0;i<B.length-2;i++){
            if(B[i]>0 && B[i]>B[i+2]-B[i+1]){ //防止越界
                return 1;
            }
        }
        return 0;
    }
}