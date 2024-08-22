#
# @lc app=leetcode id=884 lang=python
#
# [884] Uncommon Words from Two Sentences
#

# @lc code=start
class Solution(object):
    def uncommonFromSentences(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: List[str]
        """
        s1 = s1.split()
        s2 = s2.split()
        # print(s1)
        res = []
        for i in s1 + s2:
            if s1.count(i) + s2.count(i) == 1:
                res.append(i)
        return res
        
# @lc code=end

