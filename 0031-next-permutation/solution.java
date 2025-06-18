class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;

        for (int i = nums.length - 1; i >= 1; i--) {
            if(nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        if(pivot == -1) {
            reverse(nums, 0);
            return;
        }

        int index = -1;
        int diff = Integer.MAX_VALUE; 

        for(int i = pivot + 1; i < nums.length; i++) {
            if(nums[i] - nums[pivot] <= diff && nums[pivot] != nums[i] && nums[i] > nums[pivot]) {
                diff = nums[i] - nums[pivot];
                index = i;
            }
        }

        int temp = nums[pivot]; nums[pivot] = nums[index]; nums[index] = temp;
        reverse(nums, pivot + 1);
        // System.out.println(pivot + " " + index);
    }

    private void reverse(int[] arr, int start) {
        int range = arr.length - start;
        // System.out.println(range);
        int i = 0;
        while(i < range / 2) {
            int temp = arr[i + start];
            arr[i + start] = arr[range - i + start - 1];
            arr[range - i + start - 1] = temp;
            i++;
        }
    }
}
