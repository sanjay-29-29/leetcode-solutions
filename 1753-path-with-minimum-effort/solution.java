class Solution {

    class Cell {
        int i;
        int j;
        int maxDiff;

        Cell(int _i, int _j, int _maxDiff) {
            i = _i;
            j = _j;
            maxDiff = _maxDiff;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        Queue<Cell> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.maxDiff, b.maxDiff));
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        heap.add(new Cell(0, 0, 0));

        while (!heap.isEmpty()) {
            Cell curr = heap.poll();

            if (curr.i == heights.length - 1 && curr.j == heights[0].length - 1) {
                return curr.maxDiff;
            }

            if(visited[curr.i][curr.j]){
                continue;
            }

            int[][] travelArr = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

            for (int[] arr : travelArr) {
                int uX = curr.i + arr[0];
                int uY = curr.j + arr[1];
                if (!(uX >= 0 && uX < heights.length) || !(uY >= 0 && uY < heights[0].length)) {
                    continue;
                }
                int uDistance = Math.max(curr.maxDiff, Math.abs(heights[curr.i][curr.j] - heights[uX][uY]));
                visited[curr.i][curr.j] = true;
                heap.add(new Cell(uX, uY, uDistance));
            }
        }

        return -1;
    }
}
