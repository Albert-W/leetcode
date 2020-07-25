import java.util.Arrays;
public class MaxProductOfThree {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] B = A.clone();
        Arrays.sort(B);
        return Math.max(B[0]*B[1]*B[A.length-1], B[A.length-3]*B[A.length-2]*B[A.length -1] );
    }
}

