#
# @lc app=leetcode id=345 lang=python3
#
# [345] Reverse Vowels of a String
#

# @lc code=start
class Solution:
    def reverseVowels(self, s: str) -> str:
        arr = list(s)
        left = 0
        right = len(s) - 1
        vowels = set("aeiouAEIOU")
        while left < right:
            while left < len(s) and arr[left] not in vowels: 
                left += 1 
            while right >=0 and arr[right] not in vowels:
                right -= 1
            if left < right:
                arr[left], arr[right] = arr[right], arr[left]
                left += 1
                right -= 1
            # print(arr)
        return "".join(arr)
# @lc code=end

