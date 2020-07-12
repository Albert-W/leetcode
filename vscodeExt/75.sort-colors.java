/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // [0,index0) are 0s
        int index0 = 0;
        // (index2, nums.length-1] are 2s;
        int index2 = nums.length-1;
        for(int i =0;i<=index2;){
            if(nums[i]==0){
                int t = nums[index0];
                nums[index0] =0;
                nums[i] = t;
                index0++;
                i++;
            } else if (nums[i]==1){
                i++;
            } else {
                int t = nums[index2];
                nums[index2] =2;
                nums[i] = t;
                index2--;
            } 
        }
        
    }
}
// @lc code=end

