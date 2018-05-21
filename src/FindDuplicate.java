import java.util.Arrays;

/*
287. Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3

Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDuplicate {
    //the arrays indexs can be used as a map;
    //find the circle with different speed;
    //because the maximum size of the circle is n;
    //***Floyd cycle detection method***
    //time complexity O(m+n) space complexity O(1);
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            //two times faster;
            fast = nums[nums[fast]];
        }
        //the length of slow node is an integral multiple of the length of loop.
        //find the start point;
        // if start=nums[0], it would be one step ahead. the loop will never end;
        int start = 0;
        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }
        return start;

    }

    //binary Search O(nlgn);
    public int findDuplicate3(int[] nums) {
        int sat = 0, end = nums.length - 1;
        while (sat < end) {
            int mid = sat + (end - sat) / 2;
            //count the numbers less than mid;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count > mid) end = mid;
            else sat = mid + 1;

        }
        return end;
    }


    //sort first; O(nlgn)
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return 0;
    }


    //the array starts from 1 to n-1; no, it's not;
//    public int findDuplicate(int[] nums) {
//        int res=0;
//        for (int i = 0; i < nums.length; i++) {
//            res ^= nums[i]^i;
//        }
//        return res;
//
//    }
}
