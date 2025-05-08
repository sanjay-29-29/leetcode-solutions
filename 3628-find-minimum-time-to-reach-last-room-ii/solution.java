class Solution {
    public int minTimeToReach(int[][] moveTime) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];

        heap.offer(new int[] { 0, 0, 0, 0 });

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int i = curr[0];
            int j = curr[1];
            int time = curr[2];
            int moveLength = curr[3];

            if (i == moveTime.length - 1 && j == moveTime[0].length - 1) {
                return time;
            }

            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            int p = 1;

            if(moveLength % 2 != 0) {
                p = 2;
            }
            
            for (int[] d : dir) {
                int[] newDir = new int[] { d[0] + i, d[1] + j, time, moveLength + 1 };
                boolean a = (0 <= newDir[0] && newDir[0] < moveTime.length);
                boolean b = (0 <= newDir[1] && newDir[1] < moveTime[0].length);
                if (!a || !b) {
                    continue;
                }
                if (moveTime[newDir[0]][newDir[1]] > time) {
                    newDir[2] = moveTime[newDir[0]][newDir[1]] + p;
                } else {
                    newDir[2] += p;
                }
                heap.offer(newDir);
            }
        }

        return -1;
    }

}
