class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int oddPointer = 0;
        int evenPointer = 0;

        while (oddPointer < nums.length && evenPointer < nums.length) {
            if (!(evenPointer % 2 == 0 && nums[evenPointer] % 2 != 0)) {
                evenPointer++;
                continue;
            }

            if (!(oddPointer % 2 != 0 && nums[oddPointer] % 2 == 0)) {
                oddPointer++;
                continue;
            }

            int temp = nums[oddPointer];
            nums[oddPointer] = nums[evenPointer];
            nums[evenPointer] = temp;
            evenPointer++;
            oddPointer++;
        }

        return nums;
    }
}
