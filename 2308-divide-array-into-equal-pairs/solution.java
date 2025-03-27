class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int pairs = nums.length / 2;
        int count = 0; 
        
        for(int i : map.keySet()){
            int key = map.get(i);
            if(key % 2 == 0){
                count += key / 2;
            }else{
                return false;
            }
        }

        if(count == pairs){
            return true;
        }
        return false;
    }
}
