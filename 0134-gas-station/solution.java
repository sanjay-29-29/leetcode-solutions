class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0, costTotal = 0;
        for(int i  = 0; i < gas.length; i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
        }

        if(gasTotal - costTotal < 0) {
            return -1;
        }

        int idx = Integer.MAX_VALUE, tank = 0; 

        for(int i = 0; i < gas.length; i++) {
            int curr = gas[i] - cost[i];
            tank += curr;
            
            if(tank + curr < curr) {
                tank = 0;
                idx = Integer.MAX_VALUE;
            } else {
                idx = Math.min(i, idx);
            }
        }

        return idx;
    }
}
