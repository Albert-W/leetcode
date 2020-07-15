/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }


        int max = 0;
        int begin = 0;
        int end = 0;
        //[begin, end] is the test example
        for(;end<s.length();end++){
            char c = s.charAt(end);
            int i = s.indexOf(c,begin);
            // find repeated char
            if(i>=begin && i<end){
                begin = i+1;
            }
            if(end - begin > max){
                max = end -begin;
            }
        }
        return max+1;
        
    }
}
// @lc code=end

