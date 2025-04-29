class WordDictionary {
    class Node {
        Node[] node = new Node[26];
        boolean wordEnd;
    }

    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (temp.node[word.charAt(i) - 'a'] != null) {
                temp = temp.node[word.charAt(i) - 'a'];
            } else {
                temp.node[word.charAt(i) - 'a'] = new Node();
                temp = temp.node[word.charAt(i) - 'a'];
            }
        }
        temp.wordEnd = true;
    }

    public boolean search(String word) {
        if (!word.contains(".")) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                temp = temp.node[word.charAt(i) - 'a'];
                if (temp == null) {
                    return false;
                }
            }
            return temp.wordEnd;
        }

        Queue<Node> bfs = new LinkedList<>();
        bfs.add(root);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                int size = bfs.size();
                while (size > 0) {
                    Node n = bfs.poll();
                    if (n == null) {
                        size--;
                        continue;
                    }
                    size--;
                    for (int j = 0; j < 26; j++) {
                        bfs.add(n.node[j]);
                    }
                }
            } else {
                int size = bfs.size();
                while (size > 0) {
                    Node n = bfs.poll();
                    if (n == null) {
                        size--;
                        continue;
                    }
                    size--;
                    bfs.add(n.node[word.charAt(i) - 'a']);
                }
            }
        }
        while (!bfs.isEmpty()) {
            Node n = bfs.poll();
            if (n != null && n.wordEnd) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
