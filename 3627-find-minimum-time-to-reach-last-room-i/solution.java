class Solution {
    public int minTimeToReach(int[][] moveTime) {
        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });
        boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        heap.add(new int[] { 0, 0, 0 });

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            if (curr[0] == moveTime.length - 1 && curr[1] == moveTime[0].length - 1) {
                return curr[2];
            }

            if (visited[curr[0]][curr[1]]) {
                continue;
            }

            visited[curr[0]][curr[1]] = true;

            for (int[] move : dir) {
                int[] newDir = new int[] {
                        curr[0] + move[0],
                        curr[1] + move[1],
                        curr[2]
                };

                boolean exit1 = (0 <= newDir[0] && newDir[0] < moveTime.length);
                boolean exit2 = (0 <= newDir[1] && newDir[1] < moveTime[0].length);

                if (!exit1 || !exit2) {
                    continue;
                }

                if (newDir[2] >= moveTime[newDir[0]][newDir[1]]) {
                    newDir[2] += 1;
                } else {
                    newDir[2] = moveTime[newDir[0]][newDir[1]] + 1;
                }

                heap.add(newDir);
            }
        }

        return -1;
    }
}
