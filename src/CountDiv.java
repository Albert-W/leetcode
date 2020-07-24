import java.util.stream.Stream;
import java.util.stream.IntStream;

public class CountDiv {
    public static void main(String[] args) {
        long a = IntStream.range(11, 345).filter(p-> p%17==0).count();
        System.out.println(a);
    }
    
}
class Solution {
    public int solution(int A, int B, int K) {
        if((B-A)%K ==0 ){
            return (B-A)/K ;
        }
    }



    public int solution_e(int A, int B, int K) {
        // write your code in Java SE 8
        // B/K + 1 =[0,B]中 满足条件数。
        // A/K + 1 =[0,A]中 满足条件数。
        // 两者相减，再判断A, 

        if( A%K == 0){
            return B/K - A/K + 1;
        } else {
            return B/K - A/K ;
        }

    }
}