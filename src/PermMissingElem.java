public class PermMissingElem {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] memo = new int[A.length + 1];
        for(int i:A){
            if( i>=1 && i<=A.length){
                memo[i] = 1;
            }
        }
        int i;
        for(i = 1;i<=A.length;i++){
            if(memo[i]==0){
                break;
            }
        }
        return i;
    }
}