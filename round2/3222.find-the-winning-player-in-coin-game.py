#
# @lc app=leetcode id=3222 lang=python
#
# [3222] Find the Winning Player in Coin Game
#

# @lc code=start
class Solution(object):
    def losingPlayer(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: str
        """
        # each round requires x = 1, y = 4. 
        # Get how many rounds of each stack, for the minimum rounds, we will now the winner.
        round_x = x // 1
        round_y = y // 4
        min_round = min(round_x, round_y)
        if min_round % 2 == 0:
            return "Bob"
        else:
            return "Alice"

# @lc code=end

