class Solution {
    public String removeStars(String s) {
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='*'){
                stack.pop();
            }else{
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        String val = "";
        List<String> s_arr = new ArrayList(stack);
        for(int i=0;i<s_arr.size();i++ ){
            val += s_arr.get(i);
        }
        return val;
    }
}
