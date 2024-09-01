class Solution {
    public String mergeAlternately(String word1, String word2) {
        int length;
        if(word1.length()>word2.length()){
            length = word1.length();
        }
        else{
            length = word2.length();
        }
        length += 1;
        String word = "";
        for(int i=0;i<length;i++){
            if(i<word1.length()){
                word += word1.charAt(i);
            }
            if(i<word2.length()){
                word+= word2.charAt(i);
            }
        }
        return word;
    }
}
