public class OddOccurencesInArray {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 0;
        for(int i :A){
            res ^= i;
        }
        return res;
    }
}