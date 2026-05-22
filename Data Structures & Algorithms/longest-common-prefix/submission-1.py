class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""
        
        res = ""
        
        # Iterate through the characters of the first string
        for i in range(len(strs[0])):
            # Compare this character with the same index in all other strings
            for s in strs:
                # If we go out of bounds of the current string 's' OR 
                # the characters don't match, return the result
                if i == len(s) or s[i] != strs[0][i]:
                    return res
            
            # If all strings have the same character at index i, add it to the result
            res += strs[0][i]
            
        return res