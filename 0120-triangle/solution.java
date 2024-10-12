class Solution {
    HashMap<String, Integer> map;

    public int minimumTotal(List<List<Integer>> triangle) {
        map = new HashMap<>();
        return minimumTotal(triangle, 0, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int col, int row){
        String key = col + "," + row;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(col > triangle.size() - 1){
            return 0;
        }

        int currentVal = triangle.get(col).get(row);
        int val = Math.min(currentVal + minimumTotal(triangle, col + 1, row), currentVal + minimumTotal(triangle, col + 1, row+1));
        map.put(key, val);
        return val;
    }
}
