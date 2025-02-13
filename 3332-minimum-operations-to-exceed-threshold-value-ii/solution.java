class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums.length <= 1){
            return 0;
        }

        Queue<Long> queue = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++){
            queue.add((long)nums[i]);
        }

        int count = 0;

        while(true){
            if(queue.size() < 2){
                return count;
            }
            long min1 = queue.poll();
            if(min1 >= k){
                return count;
            }
            long min2 = queue.poll();
            count++;
            queue.offer(Math.min(min1, min2) * 2 + Math.max(min1, min2));
        }

        //return count;
    }
}
