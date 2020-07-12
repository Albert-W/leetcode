import java.util.Arrays;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = partition(nums, 0, nums.length-1);
        if(index == k -1 ){
            return nums[index];
        }
        if(index < k -1){
            return findKthLargest(Arrays.copyOfRange(nums, index+1, nums.length), k-index -1);
        } else {
            return findKthLargest(Arrays.copyOfRange(nums, 0, index), k);
        }

        // return 0;
    }

    // return the right index of end;
    // find from [begin, end]
    public int partition(int[] nums, int begin, int end){
        if(begin < 0 || end >= nums.length){
            return -1;
        }
        int anchor = nums[end];
        // put every elem larger then anchor to the end;
        int place = end -1;
        for(int i = begin;i<=place;){
            //change the direction at here.
            if(nums[i]<=anchor){
                int t = nums[place];
                nums[place] = nums[i];
                nums[i] = t;
                place -=1;
            } else{
                i+=1;
            }
        }
        // swich placeholder and anchor;
        int t = nums[place+1];
        nums[place+1] = anchor;
        nums[end] = t;

        return place+1;
    }
}
// @lc code=end

