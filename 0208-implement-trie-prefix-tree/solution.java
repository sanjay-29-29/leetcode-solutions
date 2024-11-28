class TrieNode {
    TrieNode[] child;
    boolean wordEnd;

    public TrieNode() {
        wordEnd = false;
        child = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            if (curr.child[word.charAt(i) - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.child[word.charAt(i) - 'a'] = newNode;
            }
            curr = curr.child[word.charAt(i) - 'a'];
        }

        curr.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            if (curr.child[word.charAt(i) - 'a'] != null) {
                curr = curr.child[word.charAt(i) - 'a'];
            }else{
                return false;
            }
        }

        return curr.wordEnd;
    }

    public boolean startsWith(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            if (curr.child[word.charAt(i) - 'a'] != null) {
                curr = curr.child[word.charAt(i) - 'a'];
            }else{
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
