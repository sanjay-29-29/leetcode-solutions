class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();
        int j = 0;

        for(int i = 0; i < s.length(); i++){
            if(j < spaces.length && spaces[j] == i){
                str.append(' ');
                j++;
            }
            str.append(s.charAt(i));
        }

        return str.toString();
    }
}
