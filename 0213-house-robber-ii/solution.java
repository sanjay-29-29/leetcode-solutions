class Solution {
    int[] nums;
    
    public int rob(int[] nums) {
        this.nums = nums;
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(robHouse(1, nums.length - 1, new HashMap<>()), robHouse(0, nums.length - 2, new HashMap<>()));
    }

    private int robHouse(int index, int endIndex, Map<Integer, Integer> map){
        if(index > endIndex){
            return 0;
        }
        
        if(map.containsKey(index)){
            return map.get(index);
        }    

        int val = Math.max(nums[index] + robHouse(index + 2, endIndex, map), robHouse(index + 1, endIndex, map));
        map.put(index, val);
        return val;
    }
}
