class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < gifts.length; i++) {
            maxHeap.add(gifts[i]);
        }

        for (int i = 0; i < k; i++) {
            int maxEle = maxHeap.remove();
            maxEle = (int) Math.sqrt(maxEle);
            maxHeap.add(maxEle);
        }

        long ret = 0;
        while (!maxHeap.isEmpty()) {
            ret += maxHeap.remove();
        }

        return ret;
    }
}
