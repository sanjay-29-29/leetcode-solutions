class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        double max = 0;

        for(int[] i : dimensions) {
            double val = (i[0] * i[0]) + (i[1] * i[1]);
            if(val > max) {
                res = i[0] * i[1];
                max = val;
            } else if(val == max) {
                res = Math.max(res, i[0] * i[1]); 
            }
        }

        return res;
    }
}
