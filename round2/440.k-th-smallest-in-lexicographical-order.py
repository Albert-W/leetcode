#
# @lc app=leetcode id=440 lang=python3
#
# [440] K-th Smallest in Lexicographical Order
#

# @lc code=start
class Solution:
    def getReqNum(self, a, b, n):
        gap = 0
        while a <= n:
            gap += min(n + 1, b) - a
            a *= 10
            b *= 10
        return gap

    def findKthNumber(self, n: int, k: int) -> int:
        num = 1
        i = 1
        while i < k:
            req = self.getReqNum(num, num + 1, n)
            if i + req <= k:
                i += req
                num += 1
            else:
                i += 1
                num *= 10
        return num
        
    def findKthNumber_TLE(self, n: int, k: int) -> int:
        # Find the lexicographical next 
        # if it's the kth return
        current = 1
        for _ in range(k-1):
            # print(current)
            current = self.getNext(current, n)
        return current

    def getNext(self, current: int, n: int) -> int: 
        if current * 10 <= n:
            return current * 10 
        if current == n:
            current //= 10 
        current += 1
        while current % 10 == 0:
            current //= 10
        return current
            
    
        
# @lc code=end

