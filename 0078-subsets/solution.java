class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int nums[];

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        recursion(new ArrayList<>(), 0);
        return list;
    }

    private void recursion(List<Integer> l, int index){
        if(index > nums.length - 1){
            list.add(l);
            return;
        }
        
        List<Integer> newL = new ArrayList<>(l);
        newL.add(nums[index]);

        recursion(newL, index + 1);
        recursion(l, index + 1);
    }
}
