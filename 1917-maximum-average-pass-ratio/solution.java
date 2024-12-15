class Solution {
    class Hall {
        int pass;
        int total;
        double fut_ratio;

        public void incTotal() {
            total = total + 1;
            pass = pass + 1;
            fut_ratio = calculateFutureRatio(pass, total);
        }

        Hall(int _pass, int _total) {
            pass = _pass;
            total = _total;
            fut_ratio = calculateFutureRatio(pass, total);
        }

        private double calculateFutureRatio(int pass, int total) {
            return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
        }

        public String toString() {
            return pass + " " + total + " " + fut_ratio;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Hall> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.fut_ratio, a.fut_ratio));

        for (int i = 0; i < classes.length; i++) {
            maxHeap.add(new Hall(classes[i][0], classes[i][1]));
        }

        //System.out.println(maxHeap);

        for (int i = 0; i < extraStudents; i++) {
            Hall curr = maxHeap.remove();
            curr.incTotal();
            maxHeap.add(curr);
        }

        double ratio = 0;

        while (!maxHeap.isEmpty()) {
            Hall curr = maxHeap.remove();
            ratio += (double) curr.pass / curr.total;
            // System.out.println(curr.pass + " " + curr.total);
            // System.out.println(curr.pass / curr.total);
        }

        return ratio / classes.length;
    }
}
