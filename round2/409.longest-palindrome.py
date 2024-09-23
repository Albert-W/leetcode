#
# @lc app=leetcode id=409 lang=python3
#
# [409] Longest Palindrome
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> int:
        res = 0
        flag = 0
        m = {} # to count the numbers of each char
        for c in s:
            if c in m:
                m[c] += 1
            else:
                m[c] = 1
        # print(m)
        for v in m.values():
            # print(v)
            if v % 2 == 1:
                flag = 1
                res += v - 1
            else:
                res += v
        
        return res + flag 
                
        
# @lc code=end

