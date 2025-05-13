class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long [] freq = new long [26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long[] newFreq = new long[26];
            for(int j = 0; j < 25; j++) {
                newFreq[j + 1] = freq[j];
            }
            newFreq[0] += freq[25];
            newFreq[0] %= 1000000007;
            newFreq[1] += freq[25];
            newFreq[1] %= 1000000007;
            freq = newFreq;
        }

        long sum = 0;
        for(int i = 0; i < 26; i++) {
            sum += freq[i];
            sum = sum % 1000000007;
        } 
        return (int) sum;
    }
}
