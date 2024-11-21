class Solution {
    public String decodeString(String s) {
        return decode(s);
    }

    private String decode(String s) {
        int i = 0;
        int n = 0;
        String retString = "";

        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                int j = i + 1;
                int inCount = 1;

                String newStr = "";

                while (true) {
                    if (s.charAt(j) == ']')
                        inCount--;
                    if (s.charAt(j) == '[')
                        inCount++;
                    if(inCount == 0) break;
                    newStr += s.charAt(j);
                    j++;
                }

                String funcStr = decode(newStr);
                for (int k = 0; k < n; k++) retString += funcStr;

                i = j;
                n = 0;

            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                retString += s.charAt(i);
                n = 0;
            } else {
                n = n * 10 + (s.charAt(i) - '0');
            }
            i++;
        }

        return retString;
    }
}
