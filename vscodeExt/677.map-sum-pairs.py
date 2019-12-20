#
# @lc app=leetcode id=677 lang=python3
#
# [677] Map Sum Pairs
#

# @lc code=start
class MapSum:
    class Node:
        def __init__(self):
            self.next = {}
            self.value = 0

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.Node()
        

    def insert(self, key: str, val: int) -> None:
        cur = self.root
        for c in key:
            if c not in cur.next:
                cur.next[c] = self.Node()
            cur = cur.next[c]
        cur.value = val        

    def sum(self, prefix: str) -> int:
        cur = self.root
        for c in prefix:
            if c not in cur.next:
                return 0
            cur = cur.next[c]
        return self.sumR(cur)

    def sumR(self, root):
        res = 0
        if root == None:
            return 0
        res+= root.value                    
        for i in root.next:
            res += self.sumR(root.next[i])

        return res

# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
# @lc code=end

