class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i : map.values()) {
            max = Math.max(max, i);
        }

        int retVal = 0;
        
        for (int i : map.values()) {
            if (i == max) {
                retVal += i;
            }
        }

        return retVal;
    }
}
