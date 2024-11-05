class Solution {
    class Node{
        int i, j;
        int time;

        Node(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        int time = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.remove();
            
            // checking boundary
            boolean exp1 = (0 <= node.i && node.i < grid.length);
            boolean exp2 = (0 <= node.j && node.j < grid[0].length);

            if(!exp1 || !exp2 || visited[node.i][node.j] == 1){
                continue;
            }
            
            if(grid[node.i][node.j] == 0){
                continue;
            }

            time = node.time;
            grid[node.i][node.j] = 2; // marking as rotten
            visited[node.i][node.j] = 1;

            queue.add(new Node(node.i + 1, node.j, node.time + 1));
            queue.add(new Node(node.i - 1, node.j, node.time + 1));
            queue.add(new Node(node.i, node.j + 1, node.time + 1));
            queue.add(new Node(node.i, node.j - 1, node.time + 1));
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return time;
    }      
}
