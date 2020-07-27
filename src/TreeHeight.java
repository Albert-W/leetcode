public class TreeHeight {
    
}
class Solution {
    public int solution(Tree T) {
        // write your code in Java SE 8
        if(T == null){
            return -1;
        }
        return Math.max( solution(T.l), solution(T.r) ) + 1;
    }
}