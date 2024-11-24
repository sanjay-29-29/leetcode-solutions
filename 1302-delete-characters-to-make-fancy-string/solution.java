class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder(s);
        char a = '\0';
        int count = 1;
        int i = 0;
        StringBuilder retStr = new StringBuilder();

        while (i < s.length()) {
            if (s.charAt(i) == a) {
                count++;
            } else {
                count = 1;
            }
            if (count == 3) {
                while (i < s.length() && s.charAt(i) == a) {
                    i++;
                }
                count = 1;
            }
            if (i < s.length()) {
                a = s.charAt(i);
                retStr.append(s.charAt(i));
                i++;
            }
        }

        return retStr.toString();
    }
}
