class Solution {
    public String clearDigits(String s) {
        return recursion(s);
    }

    private String recursion(String s){
        if(s.length() == 0){
            return "";
        }

        int i = 0; 

        for(i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                s = s.substring(0, i - 1)  + s.substring(i + 1, s.length());
                return recursion(s);
            }
        }

        return s;
    }
}
