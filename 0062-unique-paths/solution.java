class Solution {
    int m, n;
    HashMap<String, Integer> map = new HashMap<>();

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        return bfs(0, 0);
    }

    public int bfs(int i, int j){
        boolean exp1 = (0 <= i && i < m);
        boolean exp2 = (0 <= j && j < n);
        String key = i + " " + j;

        if(!exp1 || !exp2){
            return 0;
        }

        if(i == m - 1 && j == n - 1){
            return 1;
        }

        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int val =  bfs(i + 1, j) + bfs(i, j + 1);
        map.put(key, val);
        return val;
    }
}
