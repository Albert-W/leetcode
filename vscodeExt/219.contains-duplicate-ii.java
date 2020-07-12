import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res = false;
        Set<Integer> s = new HashSet<>();
        for(int i =0;i<=k && i<nums.length;i++){
            if(s.contains(nums[i])){
                return true;
            }
            s.add(nums[i]);
        }
        for(int i=k+1; i<nums.length;i++){
            s.remove(nums[i-k-1]);
            if(s.contains(nums[i])){
                res = true;
                break;
            } else {
                s.add(nums[i]);
            }
        }

        return res;
        
    }
}
// @lc code=end

