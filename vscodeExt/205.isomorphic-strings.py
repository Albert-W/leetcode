#
# @lc app=leetcode id=205 lang=python3
#
# [205] Isomorphic Strings
#

# @lc code=start
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        d = {}
        for i in range(len(s)):
            if s[i] in d:
                if t[i] != d[s[i]]:
                    return False
            else:
                d[s[i]] = t[i]
        if len(d) == len(set(d.values())):        
            return True
        else:
            return False                          

        
# @lc code=end

