import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {

        Set<Integer> s = new HashSet<>();
        while(!s.contains(n)){
            // System.out.println(n);
            s.add(n);
            n = squareSum(n);
            if(n == 1){
                return true;
            } 
        }

        return false;
    }

    public int squareSum(int n){
        int res = 0;
        while(n!=0){
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }
}
// @lc code=end

