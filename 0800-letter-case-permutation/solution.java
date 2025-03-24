class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        permute(new StringBuilder(s), res, 0);
        return res;
    }

    private void permute(StringBuilder s, List<String> res, int index) {
        if (index >= s.length()) {
            res.add(s.toString());
            return;
        }
        if ('a' <= s.charAt(index) && s.charAt(index) <= 'z') {
            s.setCharAt(index, (char) (s.charAt(index) - 32));
            permute(s, res, index + 1);
            s.setCharAt(index, (char) (s.charAt(index) + 32));
            permute(s, res, index + 1);
        } else if ('A' <= s.charAt(index) && s.charAt(index) <= 'Z') {
            s.setCharAt(index, (char) (s.charAt(index) + 32));
            permute(s, res, index + 1);
            s.setCharAt(index, (char) (s.charAt(index) - 32));
            permute(s, res, index + 1);
        } else {
            permute(s, res, index + 1);
        }
    }
}
