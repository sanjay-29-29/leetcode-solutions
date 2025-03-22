class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[][] adjMat = new int[n][n];
        int[] count = new int[n];
        boolean[] visited = new boolean[n];
        int comp = 0;

        // for(int i = 0; i < n; i++){
        //     adjMat[i][i] = 1;
        // }

        for (int[] edge : edges) {
            adjMat[edge[0]][edge[1]] = 1;
            adjMat[edge[1]][edge[0]] = 1;
        }

        for(int i = 0; i < adjMat.length; i++){
            int temp = 0;
            for(int j = 0; j < adjMat.length; j++){
                if(adjMat[i][j] == 1){
                    temp++;
                }
            }
            count[i] = temp;
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> components = new HashSet<>();
            traverse(adjMat, i, visited, components);
            if (components.size() == 0) {
                continue;
            }
            if (isConnected(components, count)) {
                comp++;
            }
        }

        return comp;
    }

    public boolean isConnected(Set<Integer> components, int[] count) {
        int c = components.size();
        int temp = c * (c - 1) / 2;
        int edges = 0;
        for (int i : components) {
            edges += count[i];
        }

        edges = edges / 2; 

        if(edges == temp){
            return true;
        }
        
        return false;
    }

    public void traverse(int[][] adjMat, int edge, boolean[] visited, Set<Integer> components) {
        if (visited[edge]) {
            return;
        }

        visited[edge] = true;
        components.add(edge);

        for (int i = 0; i < adjMat.length; i++) {
            if (adjMat[edge][i] == 1) {
                traverse(adjMat, i, visited, components);
            }
        }
    }
}
