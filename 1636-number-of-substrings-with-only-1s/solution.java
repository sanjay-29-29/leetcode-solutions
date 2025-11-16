class Solution {
    public int numSub(String s) {
        int i = 0;
        long oneCount = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                int j = i;
                long count = 0;

                while (j < s.length() && s.charAt(j) == '1') {
                    j++;
                    count++;
                }
                
                i = j;
                oneCount += count * (count + 1) / 2;
                oneCount %= 1000000007;
            } else {
                i++;
            }
        }

        return (int) oneCount;
    }
}
