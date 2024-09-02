class Solution {
    public String removeStars(String s) {
        Stack<String> stack = new Stack<>();
        int index = 0;

        while(index<s.length()){
            //System.out.println(s.charAt(index));
            if(s.charAt(index) == '*' && !stack.isEmpty()){
                stack.pop();
                index++;
            }else{
                stack.push(String.valueOf(s.charAt(index)));
                index++;
            }
        }
        String str = "";
        while(!stack.isEmpty()){
            str += stack.pop();
        }
        System.out.println(str);
        String ret = "";
        for(int i=str.length()-1;i>=0;i--){
            ret += String.valueOf(str.charAt(i));
        }
        return ret;
    }
}
