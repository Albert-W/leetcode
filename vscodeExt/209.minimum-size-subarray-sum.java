/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int minLength = nums.length+1;
        int windowSum = 0;
        while(right<nums.length){
            if (windowSum < s){
                right +=1;
                // out of Bounds
                if(right<nums.length){
                    windowSum += nums[right];
                }
            } 
            if (windowSum >= s)
            {
                if(right-left < minLength){
                    minLength = right - left;
                }
                windowSum -= nums[left];
                left += 1;
            }
        }
        if(minLength == nums.length +1){
            return 0;
        }

        return minLength +1 ;
    }
}
// @lc code=end

