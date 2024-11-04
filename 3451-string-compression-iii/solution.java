class Solution {
    public String compressedString(String word) {
        String w = "";
        int i = 0;
        int count = 1;
        while(i < word.length() - 1){
            if(word.charAt(i) == word.charAt(i + 1)){
                if(count == 9){
                    w += String.valueOf(9) + word.charAt(i);
                    count = 0;
                }
                count++;
            }else{
                w += String.valueOf(count) + word.charAt(i);
                count = 1;
            }
            i++;
        }
        w += String.valueOf(count) + word.charAt(i);
        return w;
    }
}
