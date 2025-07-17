class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxVov = 0, maxCons = 0;

        for(int i = 0; i < 26; i++) {
            if('a' == 'a' + i || 'e' == 'a' + i || 'i' == 'a' + i || 'o' == 'a' + i ||
                'u' == 'a' + i
            ) {
                maxVov = Math.max(maxVov, freq[i]);
            } else {
                maxCons = Math.max(maxCons, freq[i]);
            }
        }
        
        return maxCons + maxVov;
    }
}
