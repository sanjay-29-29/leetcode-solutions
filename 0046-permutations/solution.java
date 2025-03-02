class Solution {
    private List<Integer> convertToList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, res);
        return res;
    }

    private void backTrack(int[] nums, int index, List<List<Integer>> res) {
        if (index >= nums.length) {
            res.add(convertToList(nums));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backTrack(nums, index + 1, res);
            swap(nums, index, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
