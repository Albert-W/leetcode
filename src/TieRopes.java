public class TieRopes {
    
}
class Solution {

    // O(n)
    public int solution(int K, int[] A) {
        // write your code in Java SE 8
        // 目标是 使长度不够的连在一起。 
        // 返回 之后 剩下的 长度。 
        
        int count = 0;
        int length = 0;
        for(int i:A){
            if (i>=K){
                length = 0;
                count += 1;
            } else {
                length += i;
                if(length >= K){
                    length = 0;
                    count +=1;
                }
            }
        }
        return count;
        
    }
}