class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        int count = 0;
        boolean[] arr = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                continue;
            }
            count++;
            if ((long)i * i < n) {
                for (int j = i * i; j < n; j += i) {
                    arr[j] = true;
                }
            }
        }

        return count;
    }
}

