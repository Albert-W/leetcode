#
# @lc app=leetcode id=386 lang=python3
#
# [386] Lexicographical Numbers
#

# @lc code=start
class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        res = []
        res.append(1)
        for _ in range(1,n):
            pre = res[-1]
            res.append(self.getNext(pre, n))
        return res
        
    def getNext(self, pre:int, n:int) -> int: 
        if pre * 10 <= n:
            return pre * 10
        if pre == n:
            pre = n // 10 
        
        next = pre + 1
        while next % 10 == 0:
            next //= 10
        return next
     
    def getNext_1(self, pre:int, n: int) -> int:
        if pre * 10 <= n:
            return pre * 10
        # 192, 192 -> 2
        # 100, 100 -> 11
        if pre == n:
            next = pre // 10 + 1
            while next % 10 == 0:
                next //= 10 
            return next
        if (pre + 1) % 10 == 0:
            next = pre + 1
            while next % 10 == 0:
                next //= 10
            return next 

        return pre + 1
            
         
        
        
# @lc code=end

