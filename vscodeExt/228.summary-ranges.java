/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    // recursion solution; 
    // public List<String> summaryRanges(int[] nums) {
    //     //System.out.println(Arrays.toString(nums));
    //     if (nums.length == 0) {
    //         return List.of();
    //     }
    //     if (nums.length == 1){
    //         return List.of(String.valueOf(nums[0]));
    //     }
    //     int i = 1;
    //     while( i < nums.length && nums[i]-nums[0] == i){
    //         i++;
    //     }
    //     List<String> result = new ArrayList();
    //     if (i == 1) {
    //         result.add("" + nums[0]);
    //     } else {
    //         result.add(  nums[0] + "->" + nums[i-1]);
    //     }
        
    //     result.addAll(
    //         summaryRanges(
    //             // new int[] { 68, 79, 91, 85, 62 }
    //             Arrays.copyOfRange(nums, i, nums.length)
    //         )
    //     );
    //     return result;
    // }

    //O(n) solution
    // two index solution
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }
        
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if(nums[j] - nums[j -1] != 1) {
                if (j - 1 == i) {
                    result.add(String.valueOf(nums[i]));
                } else {
                    result.add("" + nums[i] + "->" + nums[j-1]);
                }
                i = j;
            }
            j++;
        }
        if (j - 1 == i ) {
            result.add(String.valueOf(nums[i]));
        } else {
            result.add("" + nums[i] + "->" + nums[j-1]);
        }
        return result;
    }
}
// @lc code=end

