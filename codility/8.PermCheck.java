public class PermCheck {
    
}

class Solution {
    // 记录出现过的数字，只需要一遍循环
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] memo = new int[A.length];
        for(int i:A){
            if(i<=0 || i> A.length || memo[i-1] == 1){
                return 0;
            }
            memo[i-1] = 1;
        }
        return 1;
    }
}