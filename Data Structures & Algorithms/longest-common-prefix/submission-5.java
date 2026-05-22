class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }      
        // Sort the array of strings
        Arrays.sort(strs);
        
        // Get the first and last strings after sorting
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        
        // Compare characters of the first and last strings
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }        
        return s1.substring(0, idx);
    }
}