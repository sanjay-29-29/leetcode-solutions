class Solution {
    List<List<Integer>> triangle;
    Map<String, Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        return recursion(0,0);
    }

    private int recursion(int list, int index){
        if(list > triangle.size() - 1){
            return 0;
        }
        if(index > triangle.get(list).size()){
            return Integer.MAX_VALUE;
        }
        
        String key = list + " " + index;

        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int val = triangle.get(list).get(index) + Math.min(recursion(list + 1, index), recursion(list + 1, index + 1));
        map.put(key, val);
        return val;
    }   
}
