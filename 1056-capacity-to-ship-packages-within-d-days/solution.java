class Solution {
    private boolean canCarry(int[] weights, int days, int currWeight) {
        int singleDayCount = 0;
        int noOfDays = 0;

        //System.out.println(currWeight);
        int i = 0;

        while (i < weights.length) {
            if (noOfDays >= days) {
                return false;
            }
            if ((weights[i] + singleDayCount) > currWeight) {
                noOfDays++;
                singleDayCount = 0;
                continue;
            } else {
                singleDayCount += weights[i];
            }
            i++;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int right = 0;

        for (int i = 0; i < weights.length; i++) {
            right += (int) weights[i];
        }

        int left = 0;

        while (left < right) {
            int mid = (left + right) / 2;
            boolean result = canCarry(weights, days, mid);
            if (result) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
