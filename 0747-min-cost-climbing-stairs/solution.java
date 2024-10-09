class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return Math.min(recursion(cost,0, map),recursion(cost,1,map));
    }

    private int recursion(int[] cost, int i, HashMap<Integer,Integer> map){
        if(map.containsKey(i)){
            return map.get(i);
        }
        if(i > cost.length - 1){
            return 0;
        }
        int sum =  cost[i] + Math.min(recursion(cost, i+1, map), recursion(cost, i+2, map));   
        map.put(i,sum);
        return sum;
    }
}
