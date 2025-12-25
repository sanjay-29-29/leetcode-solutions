class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        int selected = 0;
        Queue<Integer> pQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i : happiness) {
            pQ.offer(i);
        }

        while(!pQ.isEmpty() && k > 0) {
            int val = pQ.poll();
            
            if(val - selected > 0) {
                res += val - selected;
                selected += 1;
                k--;
            } else {
                break;
            }
        }

        return res;
    }
}
