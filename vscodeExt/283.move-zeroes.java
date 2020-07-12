/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // [0,k) are non-zeros
        int k = 0;
        // i current index
        int i = 0; 
        for(;i<nums.length;i++){
            if( nums[i] !=0){
                nums[k] = nums[i];
                k+=1;
            }
        }
        for(;k<nums.length;k++){
            nums[k] = 0;
        }
    }
}
// @lc code=end

