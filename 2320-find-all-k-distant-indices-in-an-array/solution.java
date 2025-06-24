class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == key) {
                for(int j = i; j >= 0 && j >= i - k; j--) {
                    set.add(j);
                }
                for(int j = i; j < nums.length && j <= i + k; j++) {
                    set.add(j);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
