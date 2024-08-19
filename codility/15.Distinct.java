import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {
    
}
class Solution {
    // 通过
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> s = new HashSet<>();
        for(int i:A){
            s.add(i);
        }
        return s.size();
    }


    // 超时
    public int solution_t(int[] A) {
        // write your code in Java SE 8
        return (int) Arrays.stream(A).distinct().count();
    }
}