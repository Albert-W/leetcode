#
# @lc app=leetcode id=3206 lang=python
#
# [3206] Alternating Groups I
#

# @lc code=start
class Solution(object):
    def numberOfAlternatingGroups(self, colors):
        """
        :type colors: List[int]
        :rtype: int
        """
        res = 0
        for i in range(len(colors)):
            if colors[i-1] != colors[i] and colors[i] != colors[(i+1) % len(colors)]:
                res += 1
        return res
        
# @lc code=end

