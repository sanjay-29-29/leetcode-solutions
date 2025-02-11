class Solution {
    public String removeOccurrences(String s, String part) {
        for(int i = 0; i < s.length(); i++){
            int j = 0;
            int k = i;
            while(k < s.length() && j < part.length() && s.charAt(k) == part.charAt(j)){
                k++;
                j++;
                if(j == part.length()){
                    String removedString = s.substring(0, k - part.length()) + s.substring(k, s.length());
                    //System.out.println(removedString);
                    return removeOccurrences(removedString, part);
                 }
            }
        }

        return s;
    }
}
