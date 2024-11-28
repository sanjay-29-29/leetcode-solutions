class Solution {
    class Node {
        int x;
        int y;
        int distance;

        Node(int _x, int _y, int _distance) {
            x = _x;
            y = _y;
            distance = _distance;
        }
    }

    public int minimumObstacles(int[][] grid) {
        Deque<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();

            int x = currNode.x;
            int y = currNode.y;

            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return currNode.distance;
            }

            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                boolean exp1 = (0 <= newX && newX < grid.length);
                boolean exp2 = (0 <= newY && newY < grid[0].length);

                if (!exp1 || !exp2) {
                    continue;
                }

                if (grid[newX][newY] == 1) {
                    queue.addLast(new Node(newX, newY, currNode.distance + 1));
                } else {
                    queue.addFirst(new Node(newX, newY, currNode.distance));
                }
            }
        }

        return -1;
    }
}
