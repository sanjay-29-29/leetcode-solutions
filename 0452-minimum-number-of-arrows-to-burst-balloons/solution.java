class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int prev = 0;
        int arrow = 1;
        int curr = prev + 1;

        // for(int i = 0; i < points.length; i++){
            // for(int j = 0; j < 2; j++){
                // System.out.print(points[i][j] + " ");
            // }
            // System.out.println();
        // }

        while(curr < points.length){
            if(points[prev][1] >= points[curr][0]){
                points[prev][1] = Math.max(points[curr][0], points[prev][1]);
                curr++;
            }else{
                prev = curr;
                curr++; 
                arrow++;
            }
        }

        return arrow;
    }
}
