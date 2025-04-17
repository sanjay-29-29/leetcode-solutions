class Solution {
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    public int[][] highestPeak(int[][] isWater) {
        int[][] res = new int[isWater.length][isWater[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int[] i : res) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs(res, queue);
        return res;
    }

    private void bfs(int[][] res, Queue<int[]> queue) {
        boolean[][] visited = new boolean[res.length][res[0].length];
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int[] next = queue.poll();
                if (!(0 <= next[0] && next[0] < res.length) || !(0 <= next[1] && next[1] < res[0].length) || visited[next[0]][next[1]]) {
                    size--;
                    continue;
                }
                visited[next[0]][next[1]] = true;
                res[next[0]][next[1]] = Math.min(
                        res[next[0]][next[1]],
                        distance);
                for (int[] d : dir) {
                    queue.add(new int[] { d[0] + next[0], d[1] + next[1] });
                }
                size--;
            }
            distance++;
        }
    }
}
