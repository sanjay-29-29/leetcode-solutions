class Solution {
    public boolean isSubsequence(String s, String t) {
        int left = 0;
        int right = 0;
        if(s.equals("")){
            return true;
        }
        while(left < s.length() && right < t.length()){
            if(s.charAt(left) == t.charAt(right)){
                left++;
                right++;
            }
            else{
                right++;
            }
            if(left == s.length()){
                return true;
            }
        }
        return false;
    }
}
