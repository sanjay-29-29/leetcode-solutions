class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int k = 0;
        for(int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            res += ((c - 'A' + 1) * Math.pow(26, k++));
            // System.out.println(c - 'A' + 1);
        }

        return res;
    }
}
