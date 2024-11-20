class Solution {
    int[] coins;
    int minCoins;
    Map<String, Integer> map = new HashMap<>();

    public int change(int amount, int[] coins) {
        this.coins = coins;
        return recursion(amount, 0);
    }

    private int recursion(int amount, int index) {
        String key = index + " " + amount;

        if (amount == 0) {
            return 1;
        }

        if (index >= coins.length) {
            return 0;
        }

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (amount - coins[index] >= 0) {
            int val = recursion(amount - coins[index], index) + recursion(amount, index + 1);
            map.put(key, val);

            return val;
        }

        int val = recursion(amount, index + 1);
        map.put(key, val);
        return val;

    }
}
