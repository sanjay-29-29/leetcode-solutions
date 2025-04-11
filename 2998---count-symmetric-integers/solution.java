class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++) {
            if(isSymmetric(String.valueOf(i))) {
                count++;
            }
        }        
        return count;
    }

    private boolean isSymmetric(String s) {
        int n1 = 0, n2 = 0;
        if(s.length() % 2 != 0) {
            return false;
        }
        for(int i = 0; i < s.length() / 2; i++){
            n1 += Integer.valueOf(s.charAt(i) - '0');
        }
        for(int i = s.length() / 2; i < s.length(); i++){
            n2 += Integer.valueOf(s.charAt(i) - '0');
        }
        if(n1 == n2) {
            return true;
        }
        return false;
    }
}
