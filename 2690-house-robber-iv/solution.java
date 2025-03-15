class Solution {
    HashMap<String, Boolean> map = new HashMap<>();

    public int minCapability(int[] nums, int k) {
        int left = nums[0];
        int right = nums[0];

        for(int i : nums) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }

        while(left < right){
            int mid = (left + right) / 2;            
            if(canRob(nums, k, mid, 0)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canRob(int[] nums, int k, int cap, int index) {
        if(k == 0){
            return true;
        }
        if(index >= nums.length){
            return false;
        }

        String key = String.valueOf(cap);

        if(map.containsKey(key)){
            return map.get(key);
        }

        boolean status = false;    

        if(nums[index] <= cap){
            status = canRob(nums, k - 1, cap, index + 2) || canRob(nums, k, cap, index + 1);
            map.put(key, status);
            return status;
        }

        status = canRob(nums, k, cap, index + 1);
        map.put(key, status);
        return status;
    }
}
