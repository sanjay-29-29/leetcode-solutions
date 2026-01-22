class Solution {
    private boolean isSorted(List<Integer> nums) {
        if (nums.size() == 1) {
            return true;
        }

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        int op = 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        while (true) {
            if (isSorted(list)) {
                return op;
            }

            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;

            for (int i = 0; i < list.size() - 1; ++i) {
                if (list.get(i) + list.get(i + 1) < minVal) {
                    minVal = list.get(i) + list.get(i + 1);
                    minIdx = i;
                }
            }

            ++op;

            list.remove(minIdx + 1);
            list.set(minIdx, minVal);
        }
    }
}
