class MapSum {

    class Node {
        boolean wordEnd;
        Node[] child = new Node[26];
    }

    Node head = new Node();
    Map<String, Integer> map = new HashMap<>();

    public MapSum() {

    }

    public void insert(String key, int val) {
        Node curr = head;
        for (int i = 0; i < key.length(); i++) {
            if (curr.child[key.charAt(i) - 'a'] == null) {
                curr.child[key.charAt(i) - 'a'] = new Node();
            }
            curr = curr.child[key.charAt(i) - 'a'];
        }
        map.put(key, val);
        curr.wordEnd = true;
    }

    public int sum(String key) {
        Node curr = head;
        for (int i = 0; i < key.length(); i++) {
            if (curr.child[key.charAt(i) - 'a'] == null) {
                return 0;
            }
            curr = curr.child[key.charAt(i) - 'a'];
        }
        return recurse(curr, key);
    }

    private int recurse(Node node, String word) {
        if(node == null) {
            return 0;
        }
        int sum = 0;
        if(node.wordEnd) {
            sum += map.get(word);
        }
        for(int i = 0; i < 26; i++) {
            sum += recurse(node.child[i], word + (char)('a' + i));
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
