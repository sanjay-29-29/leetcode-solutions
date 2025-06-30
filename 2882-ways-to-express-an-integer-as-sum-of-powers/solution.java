class Solution {
    public int numberOfWays(int n, int x) {
        return recurse(n, x, 1, new HashMap<>());
    }

    private int recurse(int n, int x, int curr, Map<String, Integer> dp) {
        if (n == 0) {
            return 1;
        }
        int power = (int) Math.pow(curr, x);
        if (power > n) {
            return 0;
        }
        String key = n + " " + curr;
        if (dp.containsKey(key)) {
            return dp.get(key);
        } 
        int val = 0;
        if(n - power >= 0) {
            val = (recurse(n - power, x, curr + 1, dp) + recurse(n, x, curr + 1, dp)) % 1000000007;
        }
        dp.put(key, val);
        return val;
    }
}
