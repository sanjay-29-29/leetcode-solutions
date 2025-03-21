public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int n1 = 0;

        for(int i = 0; i < 31; i++){
            int left = (n & 1);
            // System.out.println(left);
            n1 = n1 | left;
            n1 = n1 << 1;
            n = n >> 1;
        }


        return n1 | (n & 1);
    }
}
