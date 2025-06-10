class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxOdd = 0, maxEven = 0, minOdd = 999, minEven = 999;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 0) {
                maxEven = Math.max(maxEven, freq[i]);
                if (freq[i] != 0)
                    minEven = Math.min(minEven, freq[i]);
            } else {
                maxOdd = Math.max(maxOdd, freq[i]);
                if (freq[i] != 0)
                    minOdd = Math.min(minOdd, freq[i]);
            }
        }

        return maxOdd - minEven;
    }
}
