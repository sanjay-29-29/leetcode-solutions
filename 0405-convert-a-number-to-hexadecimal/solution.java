class Solution {
    public String toHex(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int temp = num;
            temp = temp << (4 * (7 - i));
            temp = temp >>> 28;  
            // System.out.println(temp);
            res.append(getHex(temp));
        }
        res.reverse();
        int i = 0;
        while(i < res.length() - 1 && res.charAt(i) == '0'){
            res.deleteCharAt(i);
        }
        return res.toString();
    }

    private String getHex(int n) {
        if (0 <= n && n <= 9) {
            return String.valueOf(n);
        }
        if (n == 10) {
            return "a";
        }
        if (n == 11) {
            return "b";
        }
        if (n == 12) {
            return "c";
        }
        if (n == 13) {
            return "d";
        }
        if (n == 14) {
            return "e";
        }
        if (n == 15) {
            return "f";
        }
        return "";
    }
}
