class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                int currMax = right - left + 1;
                if (currMax > max) {
                    res = s.substring(left, right + 1);
                    max = currMax;
                }
                right++;
                left--;
            }
        }

        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i + 1;

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                int currMax = right - left + 1;
                if (currMax > max) {
                    res = s.substring(left, right + 1);
                    max = currMax;
                }
                right++;
                left--;
            }
        }

        return res;
    }
}
