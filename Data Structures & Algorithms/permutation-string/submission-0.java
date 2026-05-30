public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // If s1 is longer than s2, s2 cannot contain s1's permutation
        if (n1 > n2) {
            return false;
        }
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Initialize the frequencies for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Check if the initial window is a match
        if (Arrays.equals(s1Count, s2Count)) {
            return true;
        }
        
        // Slide the window across s2
        for (int i = n1; i < n2; i++) {
            // Add the next character on the right
            s2Count[s2.charAt(i) - 'a']++;
            // Remove the leftmost character of the previous window
            s2Count[s2.charAt(i - n1) - 'a']--;
            
            // Check if current window matches s1's character frequencies
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        
        return false;
    }
}