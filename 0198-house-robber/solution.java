class Solution {
    HashMap<Integer, Integer> map;
    public int rob(int[] nums) {
        map = new HashMap<>();
        return recursion(nums, 0);
    }
    private int recursion(int[] nums, int index){
        if(map.containsKey(index)){
            return map.get(index);
        }
        if(index > nums.length - 1){
            return 0;
        }
        int max = 0;
        for(int i=index;i<nums.length;i++){
            int curr = nums[i] + recursion(nums, i+2);
            if(curr>max){
                max = curr;
            }
        }
        map.put(index,max);
        return max;
    }
}
