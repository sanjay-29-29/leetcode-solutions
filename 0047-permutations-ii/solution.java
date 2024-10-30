class Solution {
    HashSet<List<Integer>> list = new HashSet<>();
    HashSet<Integer> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return new ArrayList<>(list);
    }

    private void backTrack(int[] nums, int index, List<Integer> l){
        if(index >= nums.length){
            list.add(l);
        }
        for(int i = index; i < nums.length; i++){
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            int[] arrClone = nums.clone();
            List<Integer> listClone = new ArrayList<>(l);
            listClone.add(nums[index]);
            backTrack(arrClone, index + 1, listClone);
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
