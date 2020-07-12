import java.util.HashMap;

import java.util.Map;

/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        // 以i 为基准，统计与i的距离 相等的个数。
        for(int i =0;i<points.length;i++){
            Map<Double, Integer> m = new HashMap<>();
            for(int j = 0;j<points.length;j++){
                //不要把判断条件放在循环条件
                if(i==j){continue;}
                double l = distance(points[i], points[j]);
                m.put(l,m.getOrDefault(l,0)+1);
            }
            for(int k : m.values()){
                res += k*(k-1);
            }
        }

        return res;
    }

    public double distance(int[] A, int[] B){
        if (A.length !=2 || B.length !=2)  {
            return 0;
        }

        return Math.pow(A[0]-B[0] , 2)+Math.pow(A[1]-B[1], 2);
    }
}
// @lc code=end

