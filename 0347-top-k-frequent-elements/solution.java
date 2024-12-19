class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        class Helper {
            int n;
            int c;

            Helper(int _n, int _c) {
                n = _n;
                c = _c;
            }
        }

        Queue<Helper> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.c, a.c));

        for(int i : map.keySet()){
            heap.add(new Helper(i, map.get(i)));
        }

        int[] retArr = new int[k];

        for(int i = 0; i < k; i++){
            retArr[i] = heap.poll().n;
        }

        return retArr;
    }
}
