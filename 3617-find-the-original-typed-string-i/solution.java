class Solution {
    public int possibleStringCount(String word) {
        int[] freq = new int[26];
        int i = 0, res = 1;

        while(i < word.length() - 1) {
            if(word.charAt(i) == word.charAt(i + 1)) {
                res++;
            }
            i++;
        }

        return res;
    }
}
