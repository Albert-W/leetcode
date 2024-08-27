#
# @lc app=leetcode id=1952 lang=python
#
# [1952] Three Divisors
#

# @lc code=start
class Solution(object):
    def isThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        # Check if the number is a prime number
        if n < 3:
            return False
        i = 2
        while i * i < n:
            if n % i == 0:
                return False
            i += 1
        if i * i == n:
            return True
        return False

# @lc code=end

