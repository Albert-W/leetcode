class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        s = set()
        for a in arr1:
            for i in range(len(a)):
                s.add(a[:i])

        res = 0
        for a in arr2:
            if a in s:
                res = max(res, len(a))
        return res
            
