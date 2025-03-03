class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new LinkedList<>();
        List<Integer> pv = new LinkedList<>();
        List<Integer> more = new LinkedList<>();

        for(int i : nums){
            if(i < pivot){
                less.add(i);
            }
            else if(i == pivot){
                pv.add(i);
            }else{
                more.add(i);
            }
        }

        int prev = 0;
        for(int i : less){
            nums[prev++] = i;
        }
        for(int i : pv){
            nums[prev++] = i;
        }
        for(int i : more){
            nums[prev++] = i;
        }

        return nums;
    }
}
