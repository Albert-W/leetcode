public class TennisTournament {
    
}
// Codility
// Effortless
class Solution {
    public int solution(int P, int C) {
        // write your code in Java SE 8
        if(P >= C * 2){
            return C;
        } else {
            return P/2;
        }
    }
}