class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] freqWord1 = new int[26];
        int[] freqWord2 = new int[26];

        for(int i = 0; i < word1.length(); i++){
            freqWord1[word1.charAt(i) - 'a']++;
            freqWord2[word2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26;i++){
            if(Math.abs(freqWord1[i] - freqWord2[i]) > 3){
                return false;
            }
        }

        return true;
    }
}
