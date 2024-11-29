class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++){
            maxHeap.offer(nums[i]);
        } 

        int ele = 0;

        for(int i = 0; i < k; i++){
            ele =  maxHeap.remove();
        }
        
        return ele;
    }
}
