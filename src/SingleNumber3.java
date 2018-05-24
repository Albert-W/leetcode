/*
260. Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 */
//Bit Manipulation
public class SingleNumber3 {
    //  2ms;
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        //得到两数的异或
        int temp = 0;
        for (int i : nums) temp ^= i;
        //得到最后一位的1；(得到任何一个1都行，因为它是由0，1相与得到的)
        //把原数组分成两组，两个不同的数各占一边；
        temp = temp & (-temp);
        for (int j : nums) {
            if ((j & temp) == 0) {
                res[0] ^= j;
            } else {
                res[1] ^= j;
            }
        }
        return res;
    }
}
