class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        fun(nums, 0, new ArrayList<>());
        return list;
    }

    private void fun(int[] nums, int index, List<Integer> l){
        if(index >= nums.length){
            list.add(l);
        }
        for(int i=index; i<nums.length; i++){
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            List<Integer> l2 = new ArrayList<>(l);
            int[] arr2 = nums.clone();
            l2.add(nums[index]);
            fun(arr2, index + 1, l2);
        }
    }
}
