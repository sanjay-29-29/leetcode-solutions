class Solution {
    public int[] findArray(int[] pref) {
        int val = 0;
        for(int i = 0; i < pref.length; i++){
            pref[i] = pref[i] ^ val;
            val = val ^ pref[i];
        }
        return pref;
    }
}
