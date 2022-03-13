/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        char t;
        for(int i = 0; i<s.length/2; i++) {
            t = s[i];
            s[i] = s[s.length -1 -i];
            s[s.length -1 -i] = t;
        }
    }
}
// @lc code=end

