class Solution {
    HashMap<Integer, Integer> map;
    public int jump(int[] nums) {
        map = new HashMap<>();
        return recursion(nums,0);
    }

    public int recursion(int[] nums, int index){
        if(map.containsKey(index)){
            return map.get(index);
        }
        if(index >= nums.length-1){
            return 0;
        }

        if(nums[index] == 0){
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for (int i = index + 1; i <= index + nums[index] && i < nums.length; i++) {
            int val = recursion(nums, i);
            if (val != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + val);
            }
        }
        map.put(index, min);
        return min;
    }
}
