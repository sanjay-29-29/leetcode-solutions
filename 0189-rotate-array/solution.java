class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(0, nums.length - 1, nums);
        swap(0, k - 1, nums);
        swap(k, nums.length - 1, nums);
    }

    private void swap(int left, int right, int[] nums) {
        int temp;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
