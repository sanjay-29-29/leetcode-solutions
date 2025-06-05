class UnionFind {
    int size = 0;

    int[] parent;
    int[] capacity;

    UnionFind(int size) {
        this.size = size;
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        capacity = new int[size];
        Arrays.fill(capacity, 1);
    }

    void union(int n1, int n2) {
        int parent1 = find(n1);
        int parent2 = find(n2);

        if (parent1 == parent2) {
            return;
        }

        if (parent1 < parent2) {
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
    }

    int find(int i) {
        int root = parent[i];

        if (parent[root] != root) {
            return parent[i] = find(root);
        }

        return root;
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Map<Character, Set<Character>> map = new HashMap<>();
        UnionFind uf = new UnionFind(26);

        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            uf.union((int) c1 - 'a', (int) c2 - 'a');
        }

        StringBuilder res = new StringBuilder();

        for (char c : baseStr.toCharArray()) {
            res.append((char)(uf.find(c - 'a') + 'a'));
        }

        return res.toString();
    }
}
