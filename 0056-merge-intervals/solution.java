class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int prevVal = 0;
        int curVal = 0;


        while (curVal < intervals.length) {
            if (curVal == 0) {
                curVal++; 
                continue;
            }
            // System.out.println(intervals[prevVal][0] + " " + intervals[prevVal][1]);
            if(intervals[prevVal][1] >= intervals[curVal][0]){
                if(intervals[curVal][1] < intervals[prevVal][1]){
                    curVal++;
                    continue;
                }
                intervals[prevVal][1] = intervals[curVal][1];
                curVal++;
            }else{
               prevVal++; 
               intervals[prevVal][0] = intervals[curVal][0];
               intervals[prevVal][1] = intervals[curVal][1];
               curVal++;
            }
        }

        // System.out.println(prevVal);
        
        return Arrays.copyOf(intervals, prevVal + 1);

    }
}
