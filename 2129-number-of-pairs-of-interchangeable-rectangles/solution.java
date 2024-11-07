class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long count = 0;
        Map<Double, Integer> set = new HashMap<>();

        for (int i = 0; i < rectangles.length; i++) {
            double currRatio = (double) rectangles[i][0] / (double) rectangles[i][1];
            if(set.containsKey(currRatio)){
                count += set.get(currRatio);
                set.put(currRatio, set.get(currRatio) + 1);
            }else{
                set.put(currRatio, 1);
            }
        }
        return count;
    }
}
