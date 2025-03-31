class Solution {
    class UnionFind {
        int capacity;
        int[] parent, size;

        UnionFind(int capacity) {
            this.capacity = capacity;
            parent = new int[capacity];
            size = new int[capacity];
            for(int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(size, 1);    
        }

        public int find(int ele){
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
                parent[root2] = root1;
                size[root1] += size[root2];
            }else{
                parent[root1] = root2;
                size[root2] += size[root1];
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        if(uf.find(source) == uf.find(destination)) {
            return true;
        }
        return false;
    }
}
