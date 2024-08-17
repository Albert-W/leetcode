import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
    
}
class Solution {
    // 统计目前出现的各元素的个数。 
    // 两段相减，得到区间的元素的个数。 
    // 取最小影响值。 O（4n)
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        // 用memo 预处理String;
        // 为了统一结构 长度+1
        int[][] memo = new int[4][S.length()+1];
        for(int i = 0 ;i<S.length();i++){
            //每一列都要加
            memo[0][i+1] = memo[0][i];
            memo[1][i+1] = memo[1][i];
            memo[2][i+1] = memo[2][i];
            memo[3][i+1] = memo[3][i];
            switch(S.charAt(i)){
                case 'A':
                    memo[0][i+1] += 1;
                    break;
                case 'C':
                    memo[1][i+1] += 1;
                    break;
                case 'G':
                    memo[2][i+1] += 1;
                    break;
                case 'T':
                    memo[3][i+1] += 1;
                    break;                    
            } 
        }

        int[] res = new int[P.length];
        for(int i = 0;i<P.length;i++){
            int start = Math.min(P[i], Q[i]);
            int end = Math.max(P[i], Q[i]);
            
            for(int j = 0; j< 4;j++){
                //包含start 元素在内
                if(memo[j][end+1]- memo[j][start] > 0 ){
                    res[i] = j + 1;
                    break;
                }
            }

        }
        return res;
    }






    // O M*N  超时
    public int[] solution_t(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        Map<Character, Integer> m = new HashMap<>();
        m.put('A', 1);
        m.put('C', 2);
        m.put('G', 3);
        m.put('T', 4);

        int[] res = new int[P.length];
        for(int i = 0;i<P.length;i++){
            int start = Math.min(P[i], Q[i]);
            int end = Math.max(P[i], Q[i]);
            int min = 10;
            for(int j = start;j<=end;j++){
                int t = m.get(S.charAt(j));
                if(t < min){
                    min = t; 
                }
            }
            res[i] = min;


        }
        return res;
    }

    
}