class Solution {
    int[] nums;
    Map<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        this.nums = nums;
        return robHouse(0);
    }

    private int robHouse(int index){
        if(index >= nums.length){
            return 0;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }    

        int val = Math.max(nums[index] + robHouse(index + 2), robHouse(index + 1));
        map.put(index, val);
        return val;
    }
}
