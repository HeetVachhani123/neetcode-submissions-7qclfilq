class PrefixTree {

    // Helper class representing each node in the Trie
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            // 26 lowercase English letters
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    // Initializes the prefix tree object.
    public PrefixTree() {
        root = new TrieNode();
    }
    
    // Inserts the string word into the prefix tree.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // If the character node doesn't exist, create it
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            // Move down to the child node
            node = node.children[index];
        }
        // Mark the last node as the end of a word
        node.isEndOfWord = true;
    }
    
    // Returns true if the string word is in the prefix tree.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // If the character is missing, the word doesn't exist
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        // Return true only if it's the actual end of a previously inserted word
        return node.isEndOfWord;
    }
    
    // Returns true if there is a previously inserted string word that has the prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            // If the prefix breaks early, it doesn't exist
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        // We successfully traced the whole prefix
        return true;
    }
}

/**
 * Your PrefixTree object will be instantiated and called as such:
 * PrefixTree obj = new PrefixTree();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */