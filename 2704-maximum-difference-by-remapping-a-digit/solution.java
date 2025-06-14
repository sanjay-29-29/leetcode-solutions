class Solution {
    public int minMaxDifference(int num) {
        StringBuilder max = new StringBuilder(String.valueOf(num));
        char changeDigit = ' ';
        for (int i = 0; i < max.length(); i++) {
            if (max.charAt(i) != '9' && changeDigit == ' ') {
                changeDigit = max.charAt(i);
            }
            if (changeDigit != ' ' && max.charAt(i) == changeDigit) {
                max.setCharAt(i, '9');
            }
        }

        StringBuilder min = new StringBuilder(String.valueOf(num));
        changeDigit = ' ';
        for (int i = 0; i < min.length(); i++) {
            if (min.charAt(i) != '0' && changeDigit == ' ') {
                changeDigit = min.charAt(i);
            }
            if (changeDigit != ' ' && min.charAt(i) == changeDigit) {
                min.setCharAt(i, '0');
            }
        }

        // System.out.println(max + " " + min); 
        return Integer.valueOf(max.toString()) - Integer.valueOf(min.toString());
    }
}
