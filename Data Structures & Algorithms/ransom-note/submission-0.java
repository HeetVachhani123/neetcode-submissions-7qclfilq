class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] freq = new int[26];
        
        // count letters in magazine
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // use letters for ransomNote
        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;
            
            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
}