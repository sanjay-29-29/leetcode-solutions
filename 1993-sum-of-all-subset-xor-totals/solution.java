class Solution {
    public int subsetXORSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        recursion(nums, 0, 0, list);
        int res = 0;
        for(int i : list){
            res += i;
        }
        return res;
    }

    private void recursion(int[] nums, int index, int val, List<Integer> list) {
        if (index >= nums.length) {
            list.add(val);
            return;
        }

        recursion(
                nums,
                index + 1,
                val ^ nums[index],
                list);
        recursion(
                nums,
                index + 1,
                val,
                list);
    }
}
