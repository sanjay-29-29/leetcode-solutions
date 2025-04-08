class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int i = 0;
        int ops = 0;

        while (!isUnique(map)) {
            for (int j = 0; j < 3 && i < nums.length; j++) {
                int val = map.get(nums[i]);
                if (val == 1) {
                    map.put(nums[i], 0);
                } else {
                    map.put(nums[i], val - 1);
                }
                i++;
            }
            // System.out.println(map);
            ops++;
        }

        return ops;
    }

    private boolean isUnique(Map<Integer, Integer> map) {
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                return false;
            }
        }
        return true;
    }
}
