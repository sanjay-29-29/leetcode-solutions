class Solution {
    public int[] sortArray(int[] nums) {
       mergeSort(nums, 0, nums.length - 1);
       return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, right, mid);
        }
    }

    private void merge(int[] nums, int left, int right, int mid){
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for(int i = 0; i < leftArr.length; i++){
            leftArr[i] = nums[i + left];
        }

        for(int i = 0; i < rightArr.length; i++){
            rightArr[i] = nums[mid + i + 1];
        }


        int numsIndex = left;
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex < leftArr.length && rightIndex < rightArr.length){
            if(leftArr[leftIndex] <= rightArr[rightIndex]){
                nums[numsIndex++] = leftArr[leftIndex++];
            }
            else{
                nums[numsIndex++] = rightArr[rightIndex++];
            }
        }

        while(leftIndex < leftArr.length){
            nums[numsIndex++] = leftArr[leftIndex++];
        }

        while(rightIndex < rightArr.length){
            nums[numsIndex++] = rightArr[rightIndex++];
        }
    }
}
