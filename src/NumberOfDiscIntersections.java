import java.util.Arrays;

public class NumberOfDiscIntersections {
    
}
class Solution {

    // 所有[0，A.length-1]外部的点都没有意义，
    // 因为所有的线段都一定有点在[0,A.length-1]之中。 
    // 统计 端点出现的个数；
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] start = new int[A.length];
        int[] end = start.clone();
        for(int i = 0;i<A.length ;i++){
            int s = i<A[i]?0: i-A[i]; // max(0, i-A[i]);
            start[s] += 1;
            int e = A[i] > A.length -1 -i ?A.length-1:  i+A[i]; // 防止越界，进行移位。
            end[e] += 1;
        }
        int sum = 0;
        int active = 0;
        for(int j = 0;j<A.length;j++){
            // 添加与之前线段重合的点
            sum += active * start[j];
            // 添加 当前线段中重合的点
            sum += start[j]*(start[j]-1) /2;
            // 修正当前 激活的点
            active += start[j];
            active -= end[j];
            if(sum >10000000){
                return -1;
            }
        }
        return sum;
    }



    // 二分搜索 可以提速一点。 
    // 重要的是： 重叠盘子的个数（垂线的交点数） 与 区间是否结束有关，谁结束无关。 
    // 超时 
    public int solution_t1(int[] A) {
        // write your code in Java SE 8
        long[][] memo = new long[A.length*2][2];
        // 存储盘子的开闭；

        for(int i =0 ;i<A.length;i++){
            memo[2*i][0] = (long)i-A[i];
            memo[2*i][1] = -1;
            memo[2*i+1][0] = (long)i+A[i];
            memo[2*i+1][1] = 1; 
        }
        // 先后顺序很重要。 错误会导致少统计重合点。 
        // 打开的放在前面
        // parallelSort 在Codility中不明显
        Arrays.parallelSort(memo, (a, b)-> {
            if(a[0]==b[0]){
                return (int)a[1]; // 负数在前
            } else if(a[0]>b[0]) { // 防止加减法的越界
                return 1;
            } else {
                return -1;
            }
        });
        //System.out.println(Arrays.deepToString(memo));
        int sum = 0;
        int active = 0;
        for(int j = 0 ;j<memo.length;j++){
            if(memo[j][1] == -1){
                sum += active;
                active += 1;
            } else{
                active -= 1;
            }
            if(sum >10000000){
                return -1;
            }
        }
        return sum;
    }


    // 超时
    public int solution_t(int[] A) {
        // write your code in Java SE 8
        int[][] memo = new int[A.length][2];
        for(int i =0 ;i<A.length;i++){
            memo[i][0] = i-A[i];
            memo[i][1] = i+A[i];
        }
        Arrays.sort(memo, (a, b)-> a[0]-b[0]);
        //System.out.println(Arrays.deepToString(memo));
        int sum = 0;
        for(int j = 0 ;j<A.length;j++){
            for(int k = j+1; k<A.length && memo[k][0]<=memo[j][1];k++){
                sum +=1;
                if(sum >10000000){
                    return -1;
                }
            }
        }
        return sum;


    }
}