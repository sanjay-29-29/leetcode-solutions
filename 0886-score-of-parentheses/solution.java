class Solution {
    public int scoreOfParentheses(String s) {
        //System.out.println(s);
        if(s.length() == 2){
            return 1;
        }
        if(s.length() == 0){
            return 0;
        }
        if(s.charAt(1) == ')'){
            return 1 + scoreOfParentheses(s.substring(2,s.length()));
        }
        if(s.charAt(1) == '('){
            int i = 0;
            int count = 1;
            for(i = 1; i < s.length(); i++){
                if(count == 0){
                    break;
                }
                if(s.charAt(i) == '('){
                    count++;
                }
                else{
                    count--;
                }
            }
            // System.out.println(i);
            // System.out.println(s.substring(i, s.length()));
            return 2 * scoreOfParentheses(s.substring(1, i - 1)) + scoreOfParentheses(s.substring(i, s.length()));
        }
        return 0;
    }
}
