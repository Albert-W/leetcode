/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int abs=Integer.MAX_VALUE;
        int res=0;
        if(nums.length<3)
            return abs;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int m=i+1,n=nums.length-1;
            while(m<n){
                if(nums[m]+nums[n]+nums[i]==target )
                    return target;
                if(Math.abs(nums[m]+nums[n]+nums[i] - target)<abs){
                    abs = Math.abs(nums[m]+nums[n]+nums[i] - target);
                    res = nums[m]+nums[n]+nums[i];
                }

                if(nums[m]+nums[n]+nums[i] > target )
                    n--;
                else m++;
            }

        }
        return res;

    }
}
