import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    // by store the counterpart and find it through hash;
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> m = new HashMap<>();
        // need to store index;
        for (int i = 0;i<nums.length;i++){
            if(m.containsKey(nums[i])){
                res[0] = i;
                res[1] = m.get(nums[i]);
                break;
            } else {
                m.put(target - nums[i], i);
            }
        }


        return res;
    }

    // by brute force;
    public int[] twoSum_bf(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i<nums.length; i++){
            for (int j =i ;j<nums.length;j++){
                if(nums[i]+ nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
// @lc code=end

