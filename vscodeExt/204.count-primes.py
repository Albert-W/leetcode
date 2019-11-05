#
# @lc app=leetcode id=204 lang=python3
#
# [204] Count Primes
#

# @lc code=start
class Solution:
    # Time Limit Exceeded
    # 499979
    def countPrimes_E1(self, n: int) -> int:
        # assert n> 0 
        if n < 2:
            return 0
        s = set() # the set of Primes
        # i = 1
        for i in range(2,n):
            flag = 0
            for j in s:
                if i % j == 0: # not prime
                    flag = 1
                    break
            if flag == 0:    
                s.add(i) 

        print(s)    
        return len(s)                


    def countPrimes(self, n: int) -> int:
        if n <= 2:
            return 0
        isPrime = [1]*n
        isPrime[0],isPrime[1] = 0,0
        # 选择的目标是i*k 因此i的循环范围少很多。保证不要重复寻找
        for i in range(2, int(n**0.5)+1):
            # j = 2
            # while i*j < n :
            #     isPrime[i*j] = 0
            #     j+=1
            if isPrime[i]: # 防止重复计算的优化。
                # 2i,3i,4i 都非质数，置0
                # isPrime[i*2:n:i] = [0] * len(isPrime[i*2:n:i])
                # 近一步优化：i与小与i的数相剩已经计算过了。 
                # 因此从i**2开始。
                isPrime[i**2:n:i] = [0] * len(isPrime[i**2:n:i])
        print(isPrime)
        return sum(isPrime)

        
# @lc code=end

