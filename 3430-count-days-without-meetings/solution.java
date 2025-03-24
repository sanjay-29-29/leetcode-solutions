class Solution {
    public int countDays(int days, int[][] meetings) {
        int prev = 0;
        int curr = 1;

        Arrays.sort(meetings, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        });

        while(curr < meetings.length && prev < meetings.length){
            if(meetings[prev][1] >= meetings[curr][0]){
                meetings[prev][1] = Math.max(meetings[prev][1], meetings[curr][1]);
                curr++;
            }else{
                prev++;
                meetings[prev][0] = meetings[curr][0];
                meetings[prev][1] = meetings[curr][1];
                curr++;
            }
        }

        int meetingDays = 0;
        for(int i = 0; i <= prev; i++){
            meetingDays += meetings[i][1] - meetings[i][0] + 1;
        }

        return days - meetingDays;
    }
}
