/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(int[] nums) {
        // create the new array to store the nums[i + 1] - nums[i]
        // int[] diff = new int[nums.length - 1];
        // [3,4,2,3] -> [1, -2, 1] -> false 
        int count = 0;
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < 0) {
                // diff[i] = 1;
                count++;
                if (count > 1) {
                    return false;
                }
                // flag is the index of the first decreasing number
                flag = i;
            }
        }
        if (flag == 0 || flag == nums.length - 2) {
            return true;
        }

        // if the first decreasing number is the first number or the last number
        if (nums[flag - 1] <= nums[flag + 1] || nums[flag] <= nums[flag + 2]) {
            return true;
        } else {
            return false;
        }
        
    }
}
// @lc code=end

