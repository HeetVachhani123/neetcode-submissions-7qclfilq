from typing import List

class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        # Convert list to set for O(1) lookup times
        word_set = set(words)
        memo = {}
        
        def can_form(word: str) -> bool:
            # If we've already computed the result for this word, return it
            if word in memo:
                return memo[word]
            
            # Try splitting the word at every possible index
            for i in range(1, len(word)):
                prefix = word[:i]
                suffix = word[i:]
                
                # Check if the prefix is a valid word
                # If it is, check if the suffix is a valid word OR if it can be broken down further
                if prefix in word_set and (suffix in word_set or can_form(suffix)):
                    memo[word] = True
                    return True
            
            # If no valid split is found, memorize and return False
            memo[word] = False
            return False
            
        result = []
        for word in words:
            # Empty strings shouldn't be processed as per constraints, 
            # but it's good practice to guard against them.
            if not word:
                continue
                
            if can_form(word):
                result.append(word)
                
        return result