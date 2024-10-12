class Solution {
    int row, col;
    HashMap<String, Integer> map;
    
    public int uniquePaths(int m, int n) {
        map = new HashMap<>();
        return recursion(m, n);
    }
    
    private int recursion(int i, int j){
        String key = i + "," + j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(i<0 || j<0){
            return 0;
        }
        if(i==1 && j==1){
            return 1;
        }
        int val = recursion(i-1,j) + recursion(i,j-1);
        map.put(key,val);
        return val;
    }
}
