class Solution {
    class Helper implements Comparable<Helper>{
        int x, y;
        double distance;

        Helper(int _x, int _y){
            x = _x;
            y = _y;
            distance = Math.sqrt((x * x) + (y * y));
        }

        public int compareTo(Helper h){
            return Double.compare(this.distance, h.distance);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Queue<Helper> heap = new PriorityQueue<>(); 

        for(int i = 0; i < points.length; i++){
            heap.add(new Helper(points[i][0], points[i][1]));
        }

        for(int i = 0; i < k; i++){
            Helper h = heap.poll();
            res[i][0] = h.x;
            res[i][1] = h.y;
        }

        return res;
    }
}
