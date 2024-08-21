#
# @lc app=leetcode id=744 lang=python
#
# [744] Find Smallest Letter Greater Than Target
#

# @lc code=start
class Solution(object):
    def nextGreatestLetter(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """
        l = 0
        r = len(letters) - 1
        while l <= r:
            mid = l + (r - l) / 2
            if letters[mid] <= target:
                l = mid + 1
            else:
                r = mid - 1
        # Reach the end, can't find target. 
        if l == len(letters):
            return letters[0]
        else:
            return letters[l]
        
# @lc code=end

