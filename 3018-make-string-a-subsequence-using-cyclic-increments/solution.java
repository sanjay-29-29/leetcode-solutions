class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            int c = str1.charAt(i);
            int d = str2.charAt(j);

            int nextC = c + 1;

            if(nextC > 122){
                nextC -= 26;
            }

            if (c == d || nextC == d) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(j == str2.length())
            return true;
        return false;
    }
}
