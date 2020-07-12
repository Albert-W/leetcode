/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int begin =0;
        int end = numbers.length-1;
        while(begin<end){
            if(numbers[begin]+ numbers[end]==target){
                break;
            } else if(numbers[begin]+ numbers[end]<target) {
                begin+=1;
            } else {
                end -=1;
            }

        }
        return new int[]{begin+1,end+1};
    }
}
// @lc code=end

