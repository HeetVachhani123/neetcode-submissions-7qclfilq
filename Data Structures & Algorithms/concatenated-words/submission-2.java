
class Solution {
    private Set<String> wordSet;
    private Map<String, Boolean> memo;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        wordSet = new HashSet<>();
        memo = new HashMap<>();
        List<String> result = new ArrayList<>();

        // Populate the set for O(1) lookups
        for (String word : words) {
            wordSet.add(word);
        }

        // Check each word in the array
        for (String word : words) {
            if (word == null || word.length() == 0) {
                continue;
            }
            if (canForm(word)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean canForm(String word) {
        // If we've already computed the result for this string, return it
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        // Try splitting the word at every possible index
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            // Check if prefix is a valid word. 
            // If it is, check if suffix is valid OR can be broken down further.
            if (wordSet.contains(prefix) && (wordSet.contains(suffix) || canForm(suffix))) {
                memo.put(word, true);
                return true;
            }
        }

        // If no valid split is found, memorize and return false
        memo.put(word, false);
        return false;
    }
}