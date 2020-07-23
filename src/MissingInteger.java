/*
Codility
*/

public class MissingInteger {
    
}


class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // 记录数组，只记录前半部，越界的部分舍弃
        int[] memo = new int[A.length];
        for(int i:A){
            if(i>=1 && i<=A.length){
                memo[i-1] = 1;
            }
        }
        for(int j=0;j<memo.length;j++){
            if(memo[j] == 0){
                return j + 1;
            }
        }
        return memo.length + 1;
        
        
    }
}