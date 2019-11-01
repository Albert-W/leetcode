    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = []
        if len(strs) == 0:
            return res 
        if len(strs) == 1:
            res.append(strs)
            return res 
        for item in strs:
            for group in res:
                if self.isAnagrams(item,group[0]):
                    group.append(item)
                    break
            # 创建新group
            else:        
                res.append([item])        
        return res