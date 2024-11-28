class Solution {
    class Node {
        int x, y, count;

        Node(int _x, int _y, int _count) {
            x = _x;
            y = _y;
            count = _count;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        Deque<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];
        int[][] moveGrid = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        if (grid.get(0).get(0) == 1) {
            queue.add(new Node(0, 0, 1));
        } else {
            queue.add(new Node(0, 0, 0));
        }
        while (!queue.isEmpty()) {
            Node currNode = queue.remove();

            int x = currNode.x;
            int y = currNode.y;

            if (x == grid.size() - 1 && y == grid.get(0).size() - 1){
                if (currNode.count < health)
                    return true;
                else
                    return false;
            }
            
            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            for (int[] move : moveGrid) {
                int newX = x + move[0];
                int newY = y + move[1];

                boolean exp1 = (0 <= newX && newX < grid.size());
                boolean exp2 = (0 <= newY && newY < grid.get(0).size());

                if (!exp1 || !exp2) {
                    continue;
                }

                if (grid.get(newX).get(newY) == 1) {
                    queue.addLast(new Node(newX, newY, currNode.count + 1));
                } else {
                    queue.addFirst(new Node(newX, newY, currNode.count));
                }
            }
        }

        return false;
    }
}
