class UnionFind {
    int[] parent;
    int[] size;

    UnionFind(int size) {
        this.parent = new int[size + 1];
        this.size = new int[size + 1];
        Arrays.fill(this.size, 1);
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int node1, int node2) {
        int par1 = find(node1);
        int par2 = find(node2);

        if (par1 == par2) {
            return;
        }
        if (size[par1] > size[par2]) {
            parent[par2] = par1;
            size[par1] += size[par2];
        } else {
            parent[par1] = par2;
            size[par2] += size[par1];
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] res = new int[] {-1, -1};

        for(int i = 0; i < edges.length; i++) {
            int par1 = uf.find(edges[i][0]);
            int par2 = uf.find(edges[i][1]);

            if(par1 == par2) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                uf.union(edges[i][0], edges[i][1]);
            }
        }

        return res;
    }
}
