class Solution {
    HashMap<Integer,Integer> map;
    
    Solution(){
        map = new HashMap<>();
    }

    public int minCostClimbingStairs(int[] cost) {
      return Math.min(recursion(cost,0),recursion(cost,1));
    }

    public int recursion(int[] cost, int index){
        if(index > cost.length - 1){
            return 0;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        int val = cost[index] + Math.min(recursion(cost, index+1),recursion(cost, index+2));
        map.put(index, val);
        return val;
    }
}
