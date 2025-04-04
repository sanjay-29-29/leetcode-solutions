class Solution {
    public String reverseWords(String word) {
        String res = "";
        for (String s : word.split(" ")) {
            StringBuilder str = new StringBuilder(s);
            str.reverse();
            res += str.toString() + " ";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }
}
