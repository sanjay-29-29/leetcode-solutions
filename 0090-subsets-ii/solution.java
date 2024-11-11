class Solution {
    Set<List<Integer>> list = new HashSet<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;  
        recursion(new ArrayList<>(), 0);
        return new ArrayList<>(list);  
    }

    private void recursion(List<Integer> l, int index){
        if(index > nums.length - 1){
            Collections.sort(l);
            list.add(l);
            return;
        }
        
        List<Integer> newL = new ArrayList<>(l);
        
        newL.add(nums[index]);
        
        recursion(l, index + 1);
        recursion(newL, index + 1);
    }
}
