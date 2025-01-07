class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }
        boolean pos = true;
        boolean startsWithChar = false;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-') {
                pos = false;
            }
            startsWithChar = true;
        }

        int i = 0;
        long res = 0;
        char[] arr = s.toCharArray();

        if (startsWithChar) {
            i = 1;
        }

        while (i < arr.length) {
            int curr = integerParse(String.valueOf(arr[i]));
            if (curr == -1) {
                if (!pos) {
                    return (int) -res;
                }
                return (int) res;
            }

            res = res * 10; 
            res += (int) curr;

            if (res > (long) Integer.MAX_VALUE || res < (long) Integer.MIN_VALUE) {
                if (!pos)
                    res = -res;
                if (res >= (long) Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (res <= (long) Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }

            i++;
        }

        if (!pos) {
            res = -res;
        }

        return (int) res;

    }

    public int integerParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }
}
