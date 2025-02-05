class Solution {
    private int[] calcFreq(String s1) {
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        return arr;
    }

    public boolean areAlmostEqual(String s1, String s2) {
        int[] freq1 = calcFreq(s1);
        int[] freq2 = calcFreq(s2);

        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }

        if(count == 0 || count == 2){
            return true;
        }

        return false;
    }
}
