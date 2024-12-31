class Solution {
    int[] days;
    int[] costs;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;

        return calcMinCost(0);
    }

    private int calcMinCost(int index) {
        if (index > days.length - 1) {
            return 0;
        }

        if (map.containsKey(index)) {
            return map.get(index);
        }

        int min = costs[0] + calcMinCost(index + 1);

        int i = index; 
        while (i < days.length && days[i] < (days[index] + 7)) {
            i++;
        }
        min = Math.min(min, costs[1] + calcMinCost(i));

        i = index;
        while (i < days.length && days[i] < (days[index] + 30)) {
            i++;
        }
        min = Math.min(min, costs[2] + calcMinCost(i));

        map.put(index, min);
        return min;
    }
}
