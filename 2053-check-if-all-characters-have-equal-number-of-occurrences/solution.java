class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, -1);

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int prevVal = -1;

        for(int i = 0; i < 26; i++){
            if(freq[i] != -1 && prevVal == -1){
                prevVal = freq[i];
            }else if(freq[i] != -1 && prevVal != freq[i]){
                return false;
            }
        }

        return true;
    }
}
