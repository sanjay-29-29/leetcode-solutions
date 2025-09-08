class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n; i++) {
            if(!containZero(i) && !containZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        
        return new int[]{-1, -1};
    }    

    private boolean containZero(int n) {
        String s = String.valueOf(n);
        if(s.indexOf('0') != -1) {
            return true;
        }
        return false;
    }
}
