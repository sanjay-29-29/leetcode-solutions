class Solution {
    HashMap<Integer, Integer> map;
    Solution(){
        map = new HashMap<>();
    }
    public int tribonacci(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==0){
        return 0;
        }
        if(n==1){
        return 1;
        } 
        if(n==2){
        return 1;
        }
        int val = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        map.put(n,val);
        return val;
    }
}
