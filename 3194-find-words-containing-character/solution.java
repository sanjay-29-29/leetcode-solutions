class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        String t = "" + x;
        int i = 0;

        for (String s : words) {
            if (s.contains(t)) {
                res.add(i);
            }
            i++;
        }

        return res;
    }
}
