#
# @lc app=leetcode id=211 lang=python3
#
# [211] Add and Search Word - Data structure design
#

# @lc code=start
class WordDictionary:
    class Node:
        def __init__(self):
            self.isWord = False
            self.next = {}

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.Node()
        

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        cur = self.root
        for c in word:
            if c not in cur.next:
                cur.next[c] = self.Node()
            cur = cur.next[c]
        if not cur.isWord:    
            cur.isWord = True    
        
    # 使需要使用递归。
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        # 使用递归来遍历可能。   
        return self.searchR(word, self.root)             

    # 在root 的子树中 寻找word. word第一个字符，应该在word.next 之中。 
    def searchR(self, word, root):
        # 在这里返回，打败32%的提交
        if len(word) == 0:
            # return False
            return root.isWord
        # 提前一步返回，打败85%的提交 
        # if len(word) == 1:
        #     if word[0] in root.next :
        #         return root.next[word[0]].isWord
        #     elif word[0]=='.':
        #         for i in root.next:
        #             if root.next[i].isWord:
        #                 return True
        #         return False
        #     else:
        #         return False                    
        # 变量提取，打败54% 的提交。
        c = word[0]
        if c == '.':
            for i in root.next:
                # print(word, i)
                if self.searchR(word[1:], root.next[i]):
                    return True
        else:
            if c not in root.next:
                return False
            else:
                return self.searchR(word[1:], root.next[c])                    




# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
# @lc code=end

