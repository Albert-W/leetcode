/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    // public int addDigits(int num) {
    //     while (sumDigits(num) >= 10) {
    //         num = sumDigits(num);
    //     }
    //     return sumDigits(num);
    // }
    // private int sumDigits(int num) {
    //     int result = 0;
    //     while (num / 10 > 0) {
    //         result += num % 10;
    //         num = num / 10;   
    //     }
    //     result += num;
    //     return result;
    // }

    public int addDigits(int num) {
       // num = (100a + 10b + c) = (99a + 9b + a + b + c)
       // num % 9 = (a + b + c) % 9
       if (num == 0) {
            return 0;
       } else if (num % 9 == 0) {
            return 9;
       } else {
            return num % 9;
       }
       

    }
}
// @lc code=end

