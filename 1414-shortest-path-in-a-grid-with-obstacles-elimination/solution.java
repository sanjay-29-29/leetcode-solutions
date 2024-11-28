class Solution {
    class Node {
        int x, y, obstacleCount, distance;

        Node(int _x, int _y, int _obstacleCount, int _distance) {
            x = _x;
            y = _y;
            obstacleCount = _obstacleCount;
            distance = _distance;
        }
    }

    public int shortestPath(int[][] grid, int k) {

        Deque<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        int retValue = Integer.MAX_VALUE;
        int[][] moveArray = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        queue.add(new Node(0, 0, 0, 0));

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();

            int x = currNode.x;
            int y = currNode.y;

            if (x == grid.length - 1 && y == grid[0].length - 1) {
                retValue = Math.min(currNode.distance, retValue);
            }

            if (currNode.obstacleCount > k) { 
                continue;
            }

            if (visited[x][y][currNode.obstacleCount]) {
                continue;
            }

            visited[x][y][currNode.obstacleCount] = true;

            for (int[] arr : moveArray) {
                int newX = x + arr[0];
                int newY = y + arr[1];

                boolean exp1 = (0 <= newX && newX < grid.length);
                boolean exp2 = (0 <= newY && newY < grid[0].length);

                if (!exp1 || !exp2) {
                    continue;
                }

                if (grid[newX][newY] == 1) {
                    queue.addLast(new Node(newX, newY, currNode.obstacleCount + 1, currNode.distance + 1));
                } else {
                    queue.addLast(new Node(newX, newY, currNode.obstacleCount, currNode.distance + 1));
                }
            }
        }

        retValue = retValue == Integer.MAX_VALUE ? -1 : retValue; 
        return retValue;
    }
}
