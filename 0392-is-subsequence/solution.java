class Solution {
    public boolean isSubsequence(String s, String t) {
        int slow = 0;
        int fast = 0;
        String str = "";
        while(slow<s.length() && fast<t.length()){
            if(t.charAt(fast) == s.charAt(slow)){
                slow++;
                fast++;
            }else{
                fast++;
            }
        }
        if(slow == s.length()){
            return true;
        }
        return false;
    }
}
