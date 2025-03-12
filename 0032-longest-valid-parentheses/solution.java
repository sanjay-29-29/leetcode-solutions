class Solution {
    class Helper{
        char c;
        int idx;

        Helper(char _c, int _idx){
            c = _c;
            idx = _idx;
        }
    }

    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        Stack<Helper> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new Helper(c, i));
            }
            else if(c == '('){
                stack.push(new Helper(c, i));
            }
            else{
                Helper curr = stack.pop();
                if(curr.c == '('){
                    arr[curr.idx] = 1;
                    arr[i] = 1;
                }         
            }
        }

        int max = 0;
        int curr = 0;

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == 1 && arr[i + 1] == 1){
                curr++;
                max = Math.max(curr, max);
            }else{
                curr = 0;
            }
        }
        
        if(max != 0){    
            return max + 1;
        }

        return max;
    }
}
