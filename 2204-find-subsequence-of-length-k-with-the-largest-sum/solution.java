class Solution {
    class Helper {
        int idx, value;

        Helper(int _idx, int _value) {
            idx = _idx;
            value = _value;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {
        Queue<Helper> q = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));
        for (int i = 0; i < nums.length; i++) {
            q.offer(new Helper(i, nums[i]));
        }

        Queue<Helper> q2 = new PriorityQueue<>((a, b) -> Integer.compare(a.idx, b.idx));
        for (int i = 0; i < k; i++) {
            q2.offer(q.poll());
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q2.poll().value;
        }
        return res;
    }
}
