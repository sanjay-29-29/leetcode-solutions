class Solution {
    HashMap<Integer, Boolean> map;

    public boolean canJump(int[] nums) {
        map = new HashMap<>();
        return recursion(nums, 0);
    }

    private boolean recursion(int[] nums, int i){
        if(nums.length-1 <= i){
            return true;
        }
        if(map.containsKey(i+1)){
            return map.get(i+1);
        }

        for(int j=i+1;j<=i+nums[i];j++){
            if(recursion(nums,j) == true){
                map.put(j,true);
                return true;
            };
        }
        map.put(i,false);
        return false;
    }
}
