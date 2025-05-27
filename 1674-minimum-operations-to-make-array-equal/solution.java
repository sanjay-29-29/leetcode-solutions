class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (i * 2) + 1;
        }
        int mid = 0;
        if(n % 2 == 0) {
            mid = (arr[n / 2] + arr[(n / 2) - 1]) / 2;
        } else {
            mid = arr[n / 2];
        }
        int steps = 0;
        for(int i = 0; i < n / 2; i++) {
            steps += Math.abs(arr[i] - mid);
        }
        return steps;
    }
}
