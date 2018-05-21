/*
268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    //notice: the array is start from 0;
    //bit manipulation
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }

    //by subtraction
    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res - nums[i] + (i + 1);
        }
        return res;
    }

    //by formula
    public int missingNumber3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;

    }

}
