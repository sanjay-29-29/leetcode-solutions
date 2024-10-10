class Solution {
    HashMap<String, Integer> map;
    
    public int uniquePaths(int m, int n) {
        map = new HashMap<>();
        return recursion(m,n);
    }

    public int recursion(int m, int n){
        String key = m + "," + n;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(m==1 && n == 1){
            return 1;
        }
        if(m==0 || n == 0){
            return 0;
        }else{
            int val = recursion(m-1, n) + recursion(m, n-1);
            map.put(key,val);
            return val;
        }
    }
}
