class Solution {
    private class UnionFind { 
        int[] parent, size;
        int capacity; 

        UnionFind(int capacity) { 
            this.capacity = capacity;
            parent = new int[capacity];
            size = new int[capacity];
            for(int i = 0; i < capacity; i++) { 
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int find(int ele) {
            int currRoot = parent[ele];
            int parentRoot = parent[currRoot];

            if(currRoot != parentRoot) {
                return parent[ele] = find(currRoot);
            }

            return currRoot;
        }

        public void union(int ele1, int ele2) {
            int root1 = find(ele1);
            int root2 = find(ele2);

            if(root1 == root2) {
                return;
            }

            if(size[root1] > size[root2]) {
                size[root1] += size[root2];
                parent[root2] = root1;
            } else {
                size[root2] += size[root1];
                parent[root1] = root2;
            }

            capacity--;
        }
    }

    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);

        for(int i = 0; i < strs.length; i++) {
            for(int j = 0; j < strs.length; j++) {
                if(i == j) {
                    continue;
                }
                if(check(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }

        return uf.capacity;
    }

    public boolean check(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        
        int[] freq = new int[26];
        int count = 0;

        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if(count > 2){
                return false;
            }
        }
        if(count == 2) {
            return true;
        }
        return false;
    }
}
