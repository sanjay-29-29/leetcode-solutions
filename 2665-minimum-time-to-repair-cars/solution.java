class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = Long.MAX_VALUE;

        while (left < right) {
            long mid = (left + right) / 2;
            if (canRepair(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {
        int repairCount = 0;
        for (int i = 0; i < ranks.length; i++) {
            int carCount = (int) Math.sqrt(time / ranks[i]);
            repairCount += carCount;
            if (repairCount >= cars) {
                return true;
            }
        }
        return false;
    }
}
