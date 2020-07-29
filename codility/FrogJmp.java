public class FrogJmp {
    
}
class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        if( (Y-X)%D ==0){
            return (Y-X)/D;
        } else {
            return (Y-X)/D + 1;
        }
    }
}