/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

// by brute force;
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
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

// by store the counterpart and find it throw hash;
class Solution {
    public int[] twoSum(int[] nums, int target) {
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

