class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int prev = 0;
        int curr = prev + 1;

        while(curr < intervals.length){
            if(intervals[prev][1] >= intervals[curr][0]){
                intervals[prev][1] = Math.max(intervals[curr][1], intervals[prev][1]);
                curr++;
            }else{
                prev++;
                intervals[prev][0] = intervals[curr][0];
                intervals[prev][1] = intervals[curr][1];
                curr++;
            }
        }
        int[][] newArr = new int[prev + 1][2];
        System.arraycopy(intervals, 0, newArr, 0, prev + 1);
        return newArr;
    }
}
