/*
198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */

/**
 * 需要记录每个结点的最优rob值；
 * 此后新结点最优值为max(p[i-2]+n[i], p[i-1])
 */
public class Rob {
    public int rob2(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] p =new int[nums.length];
        p[0]=nums[0];
        p[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            p[i]=Math.max(p[i-2]+nums[i],p[i-1]);
        }
        return p[nums.length-1];
    }

    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int pre=nums[0];
        int cur=Math.max(nums[0],nums[1]);
        int next=cur;
        for(int i=2;i<nums.length;i++){
            next = Math.max(pre+nums[i],cur);
            pre=cur;
            cur=next;
        }
        return next;
    }
}
