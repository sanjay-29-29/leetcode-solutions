class Solution {
    public int firstMissingPositive(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for(int i : nums) {
            if(i > 0 && !set.contains(i)){
                q.add(i);
                set.add(i);
            }
        }

        int i = 1;
        while(!q.isEmpty()) {
            int val = q.poll();
            if(val != i) {
                return i;
            }
            i++;
        }
        return i;
        
    }
}
