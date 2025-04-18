class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int j = 0;
            while((i - j) >= 0 && (i + j) < s.length()) {
                if(s.charAt(i + j) == s.charAt(i - j)) {
                    count++;
                }else{
                    break;
                }
                j++;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            int j = 0, k = 1;
            while((i - j) >= 0 && (i + k) < s.length()) {
                if(s.charAt(i + k) == s.charAt(i - j)) {
                    count++;
                }else{
                    break;
                }
                k++;
                j++;
            }
        }

        return count;
    }
}
