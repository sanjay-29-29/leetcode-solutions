class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for(int[] key : dominoes) {
            Arrays.sort(key);
            String k = key[0] + " " + key[1];
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        int count = 0;
        for(int val : map.values()) {
            count += ((val) * (val - 1)) / 2;
        }
        return count;
    }
}
