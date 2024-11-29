class Solution {
    class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;

        Node(int _x, int _y, int _weight) {
            x = _x;
            y = _y;
            weight = _weight;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.weight, n.weight);
        }
    }

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        minHeap.add(new Node(0, 0, 0));

        while (!minHeap.isEmpty()) {
            Node currNode = minHeap.remove();

            if (currNode.x == heights.length - 1 && currNode.y == heights[0].length - 1) {
                return currNode.weight;
            }

            if (visited[currNode.x][currNode.y]) {
                continue;
            }

            visited[currNode.x][currNode.y] = true;

            for (int[] dir : directions) {
                int newX = currNode.x + dir[0];
                int newY = currNode.y + dir[1];

                boolean exp1 = (0 <= newX && newX < heights.length);
                boolean exp2 = (0 <= newY && newY < heights[0].length);

                if (!exp1 || !exp2) {
                    continue;
                }

                int effort = Math.abs(heights[currNode.x][currNode.y] - heights[newX][newY]);
                int maxEffort = Math.max(currNode.weight, effort);
                minHeap.add(new Node(newX, newY, maxEffort));
            }
        }

        return -1;
    }
}
