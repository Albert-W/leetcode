/*
 * @lc app=leetcode id=1945 lang=java
 *
 * [1945] Sum of Digits of String After Convert
 */

// @lc code=start
class Solution {
    public int getLucky(String s, int k) {
        var sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int num = c - 'a' + 1;
            sb = sb.append(num);
        }
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (char c : sb.toString().toCharArray()) {
                sum += c - '0';
            }
            sb = new StringBuilder();
            sb = sb.append(sum);
        }
        return sum;
    }
}
// @lc code=end

