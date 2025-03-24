class Solution {
    public int binaryGap(int n) {
        int prev = -1, prevPrev = -1, dist = Integer.MIN_VALUE;

        for (int i = 0; i < 31; i++) {
            int temp = (n & 1);
            if (temp == 1) {
                if (prevPrev == -1) {
                    prevPrev = i;
                } else if (prev == -1) {
                    prev = i;
                    dist = Math.max(dist, prev - prevPrev);
                } else {
                    prevPrev = prev;
                    prev = i;
                    dist = Math.max(dist, prev - prevPrev);
                }
            }
            System.out.println(temp);
            n = n >>> 1;
        }
        if(dist == Integer.MIN_VALUE){
            return 0;
        }
        return dist;
    }
}
