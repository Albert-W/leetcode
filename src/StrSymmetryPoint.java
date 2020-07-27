public class StrSymmetryPoint {
    
}
class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        if(S.length() % 2 == 0){
            return -1;
        }
        int res = 0;
        char[] memo = S.toCharArray();
        int mid = S.length()/2;
        for(int i= 0; i<= S.length()/2; i++){
            if( memo[mid-i]!=memo[mid+i] ){
                return -1;
            }
        }
        return mid;
    }
}