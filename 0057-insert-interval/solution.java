class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, newArr, 0, intervals.length);
        newArr[intervals.length][0] = newInterval[0];
        newArr[intervals.length][1] = newInterval[1];

        Arrays.sort(newArr, (a, b) -> Integer.compare(a[0], b[0]));

        int prev = 0;
        int curr = prev + 1;

        while(curr < newArr.length){
            if(newArr[prev][1] >= newArr[curr][0]){
                newArr[prev][1] = Math.max(newArr[prev][1], newArr[curr][1]);
                curr++;
            }
            else{
                prev++;
                newArr[prev][0] = newArr[curr][0];
                newArr[prev][1] = newArr[curr][1];
                curr++;
            }
        }

        int[][] retArr = new int[prev + 1][2];
        System.arraycopy(newArr, 0, retArr, 0, prev + 1);
        return retArr;
    }
}
