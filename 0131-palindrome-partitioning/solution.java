class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        recursion(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void recursion(String s, int index, List<String> list, List<List<String>> res) {
        if (index >= s.length()) {
            res.add(list);
            return;
        }

        for (int j = index; j < s.length(); j++) {
            String ss = s.substring(index, j + 1);
            if (isPalindrome(ss)) {
                List<String> newL = new ArrayList<>(list);
                newL.add(ss);
                recursion(s, j + 1, newL, res);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;

        while (left < s.length() / 2) {
            if (s.charAt(left) == s.charAt(s.length() - left - 1)) {
                left++;
            } else {
                return false;
            }
        }

        return true;
    }
}
