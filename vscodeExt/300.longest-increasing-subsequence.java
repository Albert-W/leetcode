import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        if (l==0){
            return 0;
        }

        // 记录以i结尾的最长子串的长度。 
        int[] record = new int[l];
        Arrays.fill(record, 1);
        int res = 1;
        for(int i = 1;i<l;i++){
            for(int j =i-1;j>=0;j--){
                // dynamic programming.
                // 采纳j,或者不采纳
                if(nums[j]<nums[i]){
                    record[i] =Math.max(record[i], record[j]+1);
                    if(record[i]>res){
                        res = record[i];
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

