class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long zeroCount1 = 0, zeroCount2 = 0, sum1 = 0, sum2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                zeroCount1++;
            } else {
                sum1 += nums1[i];
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                zeroCount2++;
            } else {
                sum2 += nums2[i];
            }
        }
        
        if(zeroCount1 == 0 && zeroCount2 == 0 && sum1 == sum2) {
            return sum1;
        }
        if(zeroCount1 == 0 && zeroCount2 == 0 && sum1 != sum2) {
            return -1;
        }
        if(zeroCount1 == 0 && zeroCount2 != 0) {
            if(sum1 >= sum2 + zeroCount2) {
                return sum1;
            }
            return -1;
        }
        if(zeroCount1 != 0 && zeroCount2 == 0) {
            if(sum2 >= sum1 + zeroCount1) {
                return sum2;
            }
            return -1;
        }
        
        
        long minPossibleSum = 0;

        if (sum1 + zeroCount1 > sum2 + zeroCount2) {
            minPossibleSum = sum1 + zeroCount1;
        } else {
            minPossibleSum = sum2 + zeroCount2;
        }

        return minPossibleSum;
    }
}
