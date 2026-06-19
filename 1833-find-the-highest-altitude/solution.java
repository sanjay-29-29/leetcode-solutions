class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0, res = 0;

        for(int i : gain) {
            curr += i;
            res = Math.max(curr, res);
        }

        return res;
    }
}
