class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                returnArr[1] = map.get(target - nums[i]);
                returnArr[0] = i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }

        return returnArr;
    }
}
