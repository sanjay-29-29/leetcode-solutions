class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];

        q.add(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int[] val = q.poll();
            boolean a = (0 <= val[0] && val[0] < image.length);
            boolean b = (0 <= val[1] && val[1] < image[0].length);
            if (!a || !b || visited[val[0]][val[1]]) {
                continue;
            }
            visited[val[0]][val[1]] = true;
            if (image[val[0]][val[1]] == startColor) {
                image[val[0]][val[1]] = color;
                for(int[] d : dir) {
                    q.add(new int[] {val[0] + d[0], val[1] + d[1]});
                }
            }
        }

        return image;
    }
}
