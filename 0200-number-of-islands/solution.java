class Solution {
    class Node {
        int i, j;

        Node(int _i, int _j) {
            i = _i;
            j = _j;
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int noOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                noOfIslands += bfs(i, j, grid, visited);
            }
        }

        return noOfIslands;
    }

    private boolean isOutOfBound(int i, int j, int row, int col) {
        boolean a = (0 <= i && i < row);
        boolean b = (0 <= j && j < col);

        if (!a || !b) {
            return true;
        }
        return false;
    }

    private int bfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (visited[i][j] || grid[i][j] == '0') {
            return 0;
        }

        int[][] directions = {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 }
        };

        int rowMax = visited.length;
        int colMax = visited[0].length;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (isOutOfBound(node.i, node.j, rowMax, colMax) || visited[node.i][node.j]
                    || grid[node.i][node.j] == '0') {
                continue;
            }

            visited[node.i][node.j] = true;

            for (int[] direction : directions) {
                int newX = node.i + direction[0];
                int newY = node.j + direction[1];
                queue.add(new Node(newX, newY));
            }
        }

        return 1;
    }
}
