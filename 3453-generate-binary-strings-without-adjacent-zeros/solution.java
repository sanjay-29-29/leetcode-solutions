class Solution {
    List<String> res = new LinkedList<>();
    public List<String> validStrings(int n) {
        recurse("0", n);
        recurse("1", n);
        return res;
    }

    private void recurse(String str, int n) {
        if(str.length() == n) {
            res.add(str);
            return;
        }
        if(str.charAt(str.length() - 1) == '0') {
            recurse(str + "1", n);
            return;
        }
        recurse(str + "0", n);
        recurse(str + "1", n);
    }
}
