class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int lowerBound = -1;
            int upperBound = -1;

            int left = i + 1;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int val = nums[i] + nums[mid];
                if (lower <= val) {
                    right = mid - 1;
                    lowerBound = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (lowerBound == -1) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int val = nums[i] + nums[mid];
                if (val <= upper) {
                    left = mid + 1;
                    upperBound = mid;
                } else {
                    right = mid - 1;
                }
            }

            if(upperBound == -1) {
                continue;
            }

            count += upperBound - lowerBound + 1;    
        }

        return count;
    }
}
