class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }
            if(s.charAt(i) == ')'){
                if(open == 0){
                    close++;
                }else{
                    open--;
                }
            }
        }
        return open+close;
    }
}
