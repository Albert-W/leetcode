#
# @lc app=leetcode id=14 lang=python
#
# [14] Longest Common Prefix
#

# @lc code=start
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        # Loop through the first string and check the other strings 
        for i in range(len(strs[0])):
            for string in strs[1:]:
                if i > len(string) - 1 or strs[0][i] != string[i]:
                    return strs[0][:i]
        # If there is no other strings.
        return strs[0]

        
# @lc code=end

