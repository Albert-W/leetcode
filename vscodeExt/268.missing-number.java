import java.util.Collection;

/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.parallelSort(nums);
        int i = 0 ;
        for(;i<nums.length;i++){
            if(nums[i] != i){
                break;
            }
        }
        return i;
    }




    // using array as map:
    public int missingNumber_1(int[] nums) {
        int[] map = new int[nums.length+1];
        for(int i : nums){
            if(i>=0){
                map[i] = 1;
            }
        }
        int j = 0;
        for( ;j< map.length;j++){
            if(map[j]<1){
                break;
            }
        }
        return j;

    }
}
// @lc code=end

