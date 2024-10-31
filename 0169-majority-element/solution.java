class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        for(int i : map.keySet()){
            int count = map.get(i);
            if(count > nums.length/2){
                return i;
            }
        }
        
        return -1;
    }
}
