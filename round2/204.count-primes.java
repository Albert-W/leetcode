/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        // Sieve of Eratosthenes
        if (n < 2) {
            return 0;
        }
        // 0 means index i is prime, 1 means not prime; 
        int[] isPrime = new int[n + 1];

        int i = 2;
        
        while (i * i < n) {
            // if i is prime, then all its multiples are not prime
            if (isPrime[i] == 0) {
                int j = i * i;
                while (j < n) {
                    isPrime[j] = 1;
                    j += i;
                }
            }
            i++;
        }

        // Count the number of primes
        int res = 0;
        for (i = 2; i < n; i++) {
            if (isPrime[i] == 0) {
                res++;
            }
        }
        return res;
        
        
    }
}
// @lc code=end

