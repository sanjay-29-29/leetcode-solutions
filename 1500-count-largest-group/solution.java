class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            int val = recurse(i);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int max = 0, count = 0;
        for(int i : map.values()) {
            max = Math.max(i, max);
        }
        for(int i : map.values()) {
            if(max == i) {
                count++;
            }
        }
        return count;
    }

    private int recurse(int n) {
        if(n == 0) {
            return 0;
        }
        return n % 10 + recurse(n / 10);
    }
}
