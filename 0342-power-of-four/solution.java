class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 0) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                if (i % 2 == 0) {
                    count++;
                } else {
                    return false;
                }
            }
            n = n >> 1;
        }

        if (count == 1) {
            return true;
        }
        return false;
    }
}
