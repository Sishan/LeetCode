def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if (len(strs) == 0 or strs == None):
            return ""
        isSame = True
        len = 0
        result = ""
        while (isSame):
            for i in range(len(strs)):
                if (len(strs[i]) <= len or strs[i][len] != strs[0][len]):
                    break
            result.append(strs[0][len])
            
        return result
