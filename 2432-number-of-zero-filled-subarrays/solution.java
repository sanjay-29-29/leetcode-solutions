class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int left = 0, right = 0;
        while (left < nums.length && right < nums.length) {
            if (nums[left] == 0) {
                right = left;
                long g = 0, curr = 0;
                while (right < nums.length && nums[right] == 0) {
                    right++;
                    g++;
                    curr += g;
                }
                left = right;
                res += curr;
            } else {
                left++;
            }
        }

        return res;
    }

    private long fact(long val) {
        if (val == 0 || val == 1) {
            return 1;
        }
        return val * fact(val - 1);
    }
}
