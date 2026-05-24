class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Create an array to map each character to its rank in the alien dictionary
        int[] alienMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alienMap[order.charAt(i) - 'a'] = i;
        }
        
        // Compare every pair of adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            boolean foundDifference = false;
            
            // Compare characters of word1 and word2 up to the length of the shorter word
            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                // If characters differ, check their alien dictionary ranks
                if (c1 != c2) {
                    if (alienMap[c1 - 'a'] > alienMap[c2 - 'a']) {
                        return false; // word1 is lexicographically larger than word2
                    }
                    foundDifference = true;
                    break; // The words are in correct order, move to the next pair
                }
            }
            
            // If no difference was found, the longer string must come second
            if (!foundDifference && word1.length() > word2.length()) {
                return false;
            }
        }
        
        return true;
    }
}