public class MinPerimeterRectangle {
    
}
class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int l = (int)Math.sqrt(N);
        // 从小数开始找，更快
        for(; l>1;l--){
            if(N % l ==0){break;}
        }
        return 2 * (l + N/l);
    }
}