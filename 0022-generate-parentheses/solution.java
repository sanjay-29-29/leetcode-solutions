class Solution {
    public boolean validateParanthesis(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.pop();
                if(c == ')'){
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }

    private void generateParanth(String s, int n, List<String> res){
        if(s.length() == n * 2){
            if(validateParanthesis(s)){
                res.add(s);
            }
            return;
        }

        generateParanth(s + ")", n, res);
        generateParanth(s + "(", n, res);
    }

    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
       generateParanth("", n, res);
        return res;
    }
}
