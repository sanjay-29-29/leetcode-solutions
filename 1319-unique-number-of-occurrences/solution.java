class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            if(map.containsKey(val)){
                map.put(val, map.get(val)+1);
            }else{
                map.put(val,1);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val : map.values()){
            if(set.contains(val)){
                return false;
            }else{
                set.add(val);
            }
        }
        return true;
    }
}
