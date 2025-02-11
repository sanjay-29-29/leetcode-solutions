class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1 = 0;
        int i2 = 0;
        StringBuilder mergedStr = new StringBuilder();

        while(i1 < word1.length() && i2 < word2.length()){
            mergedStr.append(word1.charAt(i1));
            mergedStr.append(word2.charAt(i2));
            i1++;
            i2++;
        }

        while(i1 < word1.length()){
            mergedStr.append(word1.charAt(i1));
            i1++;
        }
        while(i2 < word2.length()){
            mergedStr.append(word2.charAt(i2));
            i2++;
        }

        return mergedStr.toString();
    }
}
