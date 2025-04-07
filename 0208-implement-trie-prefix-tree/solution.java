class Trie {
    class Node {
        Node[] node = new Node[26];
        boolean isEnd = false;
    }

    Node head = new Node();

    public void insert(String word) {
        Node temp = head;
        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            if (temp.node[s - 'a'] == null) {
                temp.node[s - 'a'] = new Node();
            }
            temp = temp.node[s - 'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        Node temp = head;
        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            if (temp.node[s - 'a'] == null) {
                return false;
            }
            temp = temp.node[s - 'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node temp = head;
        for (int i = 0; i < prefix.length(); i++) {
            char s = prefix.charAt(i);
            if (temp.node[s - 'a'] == null) {
                return false;
            }
            temp = temp.node[s - 'a'];
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
