class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String t = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '-') {
                continue;
            }else{
                t += Character.toUpperCase(s.charAt(i));
            }
        }

        int temp = 0;
        for(int i = t.length() - 1; i >= 0; i--) {
            temp++;
            if(temp == k && i != 0) {
                t = t.substring(0, i) + "-" + t.substring(i, t.length());
                temp = 0;
            }
        }

        return t.toString();
    }
}
