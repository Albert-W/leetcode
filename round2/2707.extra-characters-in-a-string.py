#
# @lc app=leetcode id=2707 lang=python3
#
# [2707] Extra Characters in a String
#

# @lc code=start
class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        # Non-Overlapping Substrings
        dict_set = set(dictionary)
        n = len(s)
        dq = [n] * (n + 1) # the number of extra char at index i
        dq[0] = 0 # Empty string
        
        #Try to reduce the number if found substring
        for i in range(1, n+1):
            for j in range(i):
                if s[j:i] in dict_set: 
                    dq[i] = min(dq[i], dq[j])
            # 
            dq[i] = min(dq[i], dq[i -1] + 1)
        return dq[n]
        
# @lc code=end

