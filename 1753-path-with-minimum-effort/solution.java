class Node implements Comparable<Node>{
    int x, y, val;

    Node(int _x, int _y, int _val){
        x = _x;
        y = _y;
        val = _val;
    }

    public int compareTo(Node node){
        return Integer.compare(this.val, node.val);
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        Queue<Node> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 


        queue.offer(new Node(0, 0, 0));
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.x == heights.length - 1 && curr.y == heights[0].length - 1){
                return curr.val;
            }
            if(visited[curr.x][curr.y] == true){
                continue;
            }
            visited[curr.x][curr.y] = true;
            for(int i = 0; i < dir.length; i++){
                int newX = curr.x + dir[i][0];
                int newY = curr.y + dir[i][1];
                if(newX < 0 || newX >= heights.length || newY < 0 || newY >= heights[0].length){
                    continue;
                }
                queue.offer(new Node(newX, newY, Math.max(curr.val, Math.abs(heights[curr.x][curr.y] - heights[newX][newY]))));
            }
        }

        return -1;
    }
}
