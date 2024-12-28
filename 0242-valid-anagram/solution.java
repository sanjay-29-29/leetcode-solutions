class Solution {
    private void count(String s, int[] arr){
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
    }

    public boolean isAnagram(String s, String t) {
        int[] cArr1 = new int[26];
        int[] cArr2 = new int[26];

        count(s, cArr1);
        count(t, cArr2);

        for(int i = 0; i < 26; i++){
            // System.out.println(cArr1[i] + " " + cArr2[i]);
            if(cArr1[i] != cArr2[i]){
                return false;
            }
        }

        return true;
    }
}
