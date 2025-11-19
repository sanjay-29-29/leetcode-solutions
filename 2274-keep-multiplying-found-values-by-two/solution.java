class Solution {
    public int findFinalValue(int[] nums, int original) {
       Set<Integer> set = new HashSet<>();
       int start = original;

       for(int i : nums) 
            set.add(i);

       while(set.contains(start)) {
            start = start * 2;
       }

       return start;
    }
}
