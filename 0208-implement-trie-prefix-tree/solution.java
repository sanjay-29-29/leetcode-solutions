class Trie {
    class Node {
        boolean wordEnd;
        Node[] node = new Node[26];
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(curr.node[c] == null){
                curr.node[c] = new Node();
                curr = curr.node[c];
            }else{
                curr = curr.node[c];
            }
        }

        curr.wordEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(curr.node[c] == null){
                return false;
            }
            curr = curr.node[c];
        }           
        if(curr.wordEnd){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for(int i = 0; i < prefix.length(); i++){
            int c = prefix.charAt(i) - 'a';
            if(curr.node[c] == null){
                return false;
            }
            curr = curr.node[c];
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
