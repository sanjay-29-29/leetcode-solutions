class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]> () {
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });

        int prev = 0;
        int curr = 1;

        while(prev < intervals.length && curr < intervals.length){
            if(intervals[prev][1] >= intervals[curr][0]){
                intervals[prev][1] = Math.max(intervals[prev][1], intervals[curr][1]);
                curr++;
            }else{
                prev++;
                intervals[prev][0] = intervals[curr][0];
                intervals[prev][1] = intervals[curr][1];
                curr++;
            }
        }

        int[][] mergedArr = new int[prev + 1][2];
        for(int i = 0; i < mergedArr.length; i++){
            mergedArr[i][0] = intervals[i][0];
            mergedArr[i][1] = intervals[i][1];
        }

        return mergedArr;
    }
}
