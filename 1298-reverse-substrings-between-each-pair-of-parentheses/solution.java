class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                String str = "";
                while(true){
                    Character c = stack.pop();
                    //System.out.println(c);
                    if(c == '(') break;
                    str += c;
                }
                for(int k = 0; k < str.length(); k++){
                    stack.push(str.charAt(k));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        StringBuilder res = new StringBuilder();

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }
}
