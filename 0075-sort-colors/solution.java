class Solution {
    public void sortColors(int[] nums) {
        int hi = nums.length - 1;
        int low = 0;
        int mid = 0;

        while(mid <= hi){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[hi];
                nums[hi] = temp;
                hi--;
            }
            else{
                mid++;
            }
        }
    }
}
