#
# @lc app=leetcode id=208 lang=python3
#
# [208] Implement Trie (Prefix Tree)
#

# @lc code=start
class Trie:
    class Node:
        def __init__(self):
            self.isWord = False
            self.next = {}


    

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.Node()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for c in word:
            if c not in cur.next:
                cur.next[c] = self.Node()
            cur = cur.next[c]    

        if not cur.isWord:
            cur.isWord = True    


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur = self.root
        for c in word:
            if c not in cur.next:
                return False
            cur = cur.next[c]
        return cur.isWord        

        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur = self.root
        for c in prefix:
            if c not in cur.next:
                return False
            cur = cur.next[c]    
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end

