class Solution {
    private boolean isPrefixAndSuffix(String a, String b){
        if(a.length() > b.length()){
            return false;
        }

        for(int i = 0; i < a.length(); i++){
           if(a.charAt(i) != b.charAt(i)) {
                return false; 
           }
        }

        int bPointer = b.length() - 1;

        for(int i = a.length() - 1; i >= 0; i--){
            if(a.charAt(i) != b.charAt(bPointer)){
                return false;
            }
            bPointer--;
        }

        return true;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    count++;
                }
            }
        }

        return count;
    }
}
