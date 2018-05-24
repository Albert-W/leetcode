/*
137. Single Number II
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */
//bit manipulation
public class SingleNumber2 {
    //先排序后比较O(nlgn)
    //hashmap O(n);
    //位运算;5ms;0(32n);
    //也可以处理3个相同，2个不同的情形；
    public int singleNumber(int[] nums) {

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            if (count % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }


    //another method; 1ms; O(n);
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int i : nums) {
            twos |= (ones & i);//叠加显示出现2次1 的位置；
            ones ^= i;//出现1次1 的记录；出现2次1 的置0；

            //下面三句，就是把ones 与twos 都出现的位置置0；
            threes = ~(ones & twos); //出现3次1的位置置0，其他置1；
            ones = (ones & threes);//3次1的位置置0，其他位置不变；
            twos = (twos & threes);//3次1的位置置0，其他位置不变；

        }
        return ones;
    }



}
