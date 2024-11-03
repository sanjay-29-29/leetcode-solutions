class Solution {
    HashSet<Integer> set = new HashSet<>();
    int[][] isConnected;
    int[] visited;

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        this.visited = new int[isConnected.length];
        int provinces = 0;
        
        for(int i = 0; i < isConnected.length; i++){
            provinces += traverse(i);
        }

        return provinces;
    }

    private int traverse(int i){
        if(visited[i] == 1){
            return 0;
        }

        visited[i] = 1;
        
        for(int k = 0; k < isConnected[i].length; k++){
            if(isConnected[i][k] == 1 && k != i){
                traverse(k);           
            }             
        }
        return 1;
    }
}
