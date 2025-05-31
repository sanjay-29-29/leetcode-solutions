class Solution {
    public int snakesAndLadders(int[][] board) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[board.length * board.length];
        int dist = 1;

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                int temp = j;
                if (board.length % 2 == 0 && i % 2 == 0) {
                    temp = board.length - j - 1;
                } else if (board.length % 2 != 0 && i % 2 != 0) {
                    temp = board.length - j - 1;
                }
                map.put(dist++, board[i][temp]);
            }
        }

        // System.out.println(map);

        q.add(1);
        dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            // for (int[] i : q) {
            //     System.out.println(i[0] + " " + i[1]);
            // }
            while (size > 0) {
                int ele = q.poll();
                if (ele == board.length * board.length) {
                    return dist;
                }
                if (visited[ele]) {
                    size--;
                    continue;
                }
                visited[ele] = true;
                for (int i = 1; i <= 6; i++) {
                    int next = ele + i;
                    if (next <= board.length * board.length) {
                        int val = map.get(next);
                        if (val == -1) {
                            q.add(next);
                        } else {
                            q.add(val);
                        }
                    }
                }
                size--;
            }
            dist++;
        }

        return -1;
    }
}
