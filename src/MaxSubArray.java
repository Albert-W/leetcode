/*
53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {
    //Dynamic Programming;
    public int maxSubArray(int[] nums) {
        //SubArray,不许[], [-1]->-1;
//        int sum=0;
//        int max=0;
        if(nums.length==0)
            return 0;
        int sum=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum>0)sum+=nums[i];
            else sum=nums[i];
            if(sum>max)
                max=sum;
        }
        return max;
    }
}
