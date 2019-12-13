#
# @lc app=leetcode id=455 lang=python3
#
# [455] Assign Cookies
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        s.sort()
        g.sort()
        lenG = len(g)-1
        lenS = len(s)-1
        count = 0
        while lenG >=0 and lenS >=0:
            if g[lenG]<= s[lenS]:
                lenG -= 1 
                lenS -= 1
                count += 1
            else :
                lenG -= 1
        return count            
        
# @lc code=end

