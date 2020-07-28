/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {

    // ["aa", "a"]
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int p = 0;
        for(;p<strs[0].length();p++){
            char c = strs[0].charAt(p);
            boolean flag = false;
            for(int i = 1;i<strs.length;i++){
                if(p>=strs[i].length() || strs[i].charAt(p) != c){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
                
    
        }
        return strs[0].substring(0, p);
        
    }
}
// @lc code=end

