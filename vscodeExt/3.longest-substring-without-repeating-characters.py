#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1    
        i = 0
        j = 1
        r = 1
        while j < len(s):
            index = s[i:j].find(s[j])
            if index != -1 :
                i = i + index + 1 
            else:
                j+=1
                if j-i> r:
                    r = j-i 
        return r
        
# @lc code=end

