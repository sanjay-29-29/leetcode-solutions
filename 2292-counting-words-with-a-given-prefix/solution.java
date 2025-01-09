class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(hasPrefix(words[i], pref)){
                count++;
            }
        }

        return count;
    }

    private boolean hasPrefix(String s, String pref){
        if(pref.length() > s.length()){
            return false;
        }

        for(int i = 0; i < pref.length(); i++){
            if(s.charAt(i) != pref.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
