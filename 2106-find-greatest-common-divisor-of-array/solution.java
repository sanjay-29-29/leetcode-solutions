class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if (a == b)
            return a;

        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }
}
