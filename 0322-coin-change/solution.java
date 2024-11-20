class Solution {
    int[] coins;
    int minCoins;
    boolean flag = false;
    Map<String, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        int val = recursion(amount, 0);
        if (flag)
            return val;
        return -1;
    }

    private int recursion(int amount, int index) {
        String key = index + " " + amount;

        if (amount == 0) {
            flag = true;
            return 0;
        }

        if (index >= coins.length) {
            return 99999;
        }

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (amount - coins[index] >= 0) {
            int val = Math.min(1 + recursion(amount - coins[index], index + 1),
                    Math.min(1 + recursion(amount - coins[index], index), recursion(amount, index + 1)));
            map.put(key, val);
            return val;
        }

        int val = recursion(amount, index + 1);
        map.put(key, val);
        return val;

    }
}
