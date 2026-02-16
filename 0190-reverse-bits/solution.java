class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++) {
            int val = (n & 1);
            n = n >>> 1;
            val = val << 31 - i;
            res = res ^ val;
            // System.out.println(Integer.toBinaryString(res));
        }

        return res;
    }
}
