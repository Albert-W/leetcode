import java.util.*;
public class CountTriangles {
    
}

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    // 使用双重游标，减化内层循环。 O(N**2)
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] memo = A.clone();
        Arrays.sort(memo);
        
        int sum = 0;
        for(int i = 0; i<A.length - 2;i++){
            int mid = i+1;
            int max = i+2;
            // 控制max的循环
            while(max < A.length){
                if(memo[i] + memo[mid] > memo[max]){
                    sum += max - mid;// mid 在此区间都满足要求。 
                    max += 1;// 条件修改放在最后
                } else if (mid < max - 1) {
                    //回到while循环，再判断 一次。
                    mid += 1;
                    //没有mid的空间，需要增大max
                } else {
                    max += 1; // 此时mid肯定还是不够；
                    mid += 1;
                }
            }
            
        }
        return sum;
    }



    // TIMEOUT ERROR O(N**3)
    public int solution_e(int[] A) {
        // write your code in Java SE 8
        int[] memo = A.clone();
        Arrays.sort(memo);
        
        int sum = 0;
        for(int i = 0; i<A.length - 2;i++){
            for(int j = i+1; j< A.length - 1;j++){
                int k = Arrays.binarySearch(memo, memo[i]+memo[j]);
                sum += k - j - 1;
            }
            
        }
        return sum;
    }


    // TIMEOUT ERROR O(N**3)
    public int solution_e(int[] A) {
        // write your code in Java SE 8
        int[] memo = A.clone();
        Arrays.sort(memo);
        
        int sum = 0;
        for(int i = 0; i<A.length - 2;i++){
            for(int j = i+1; j< A.length - 1;j++){
                int k = j + 1;
                while(k < A.length - 1 && memo[i]+memo[j] < memo[k]){
                    sum += 1;
                    k += 1;
                }
            }
            
        }
        return sum;
    }
}
