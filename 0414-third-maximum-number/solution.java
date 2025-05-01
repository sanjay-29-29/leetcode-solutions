class Solution {
    public int thirdMax(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
                heap.offer(i);
            }
        }

        int count = 0;
        int res = -1;
        boolean flag = false;

        while (!heap.isEmpty()) {
            int val = -1;
            if(!flag) {
                res = heap.poll();
                flag = true;
            }else{
                val = heap.poll();
            }
            count++;
            if (count == 3) {
                return val;
            }
        }
        return res;
    }
}
