class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] retArray = { -1, -1 };
        Arrays.sort(nums);
        int j = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                retArray[j++] = nums[i];
            }
        }

        return retArray;
    }
}
