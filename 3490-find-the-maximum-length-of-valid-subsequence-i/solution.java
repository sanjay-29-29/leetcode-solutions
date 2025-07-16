class Solution {
    public int maximumLength(int[] nums) {
        // int[] dp = new int[2];
        int even = 0, odd = 0;
        for (int i = 0; i < nums.length; i++) {
            // dp[(nums[i] + nums[i + 1]) % 2]++;
            if (nums[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        int alt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2 == 0 && nums[i + 1] % 2 != 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 == 0)) {
                alt += 1;
            }
        }
        if(alt == 0) {
            return Math.max(even, odd);
        }
        return Math.max(
                alt + 1, Math.max(even, odd));
    }

    // private int recurse(int[] nums, int i, int mod) {
    //     if(i == nums.length - 2) {
    //         if((nums[i] + nums[i + 1]) % 2 == mod) {
    //             return 1;
    //         }
    //         return 0;
    //     }
    // }
}
