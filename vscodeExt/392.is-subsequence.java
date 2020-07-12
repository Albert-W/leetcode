/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sr = s.toCharArray();
        char[] tr = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i<sr.length && j < tr.length){
            if(sr[i] == tr[j]){
                i += 1;
            }
            j += 1;
        }
        // if (i == sr.length){
        //     return true;
        // } else {
        //     return false;
        // }
        return i == sr.length;

    }
}
// @lc code=end

