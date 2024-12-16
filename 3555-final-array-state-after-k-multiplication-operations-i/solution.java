class Solution {
    class Helper {
        int index;
        int val;

        Helper(int _index, int _val) {
            index = _index;
            val = _val;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Helper> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.val, b.val);
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Helper(i, nums[i]));
        }

        // System.out.println(minHeap);

        for (int i = 0; i < k; i++) {
            Helper curr = minHeap.poll();
            nums[curr.index] *= multiplier;
            curr.val *= multiplier;
            minHeap.add(curr);
            // System.out.println(curr);
        }

        return nums;
    }
}
