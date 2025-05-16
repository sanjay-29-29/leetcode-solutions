class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>(100);

        for (int i = 0; i < groups.length; i++) {
            int prev = groups[i];
            List<String> str = new ArrayList<>(100);
            str.add(words[i]);
            for (int j = i + 1; j < groups.length; j++) {
                if (groups[j] != prev) {
                    prev = groups[j];
                    str.add(words[j]);
                }
            }
            if (str.size() > res.size()) {
                res = str;
            }
        }

        return res;
    }
}
