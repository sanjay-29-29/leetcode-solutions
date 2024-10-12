class Solution {
    HashMap<String, Integer> map;

    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return recursion(nums, 0, target, 0);
    }

    private int recursion(int[] nums, int index, int target, int current){
        String key = index + "," + current;
        if(map.containsKey(key)){
            return map.get(key);
        }

        if(target == current && index==nums.length){
            return 1;
        }
        if(index > nums.length-1){
            return 0;
        }
        int val = recursion(nums,index+1,target, current-nums[index]) + 
            recursion(nums,index+1,target, current+nums[index]);
        map.put(key,val);
        return val;
    }
}
