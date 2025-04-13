class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int val = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                val = val * 10 + (c - '0');
            } else if (c != ' ') {
                switch (sign) {
                    case '+':
                        stack.push(val);
                        break;
                    case '-':
                        stack.push(-val);
                        break;
                    case '*':
                        stack.push(stack.pop() * val);
                        break;
                    case '/':
                        stack.push(stack.pop() / val);
                        break;
                }
                val = 0;
                sign = c;
            }
        }
        
        switch (sign) {
            case '+':
                stack.push(val);
                break;
            case '-':
                stack.push(-val);
                break;
            case '*':
                stack.push(stack.pop() * val);
                break;
            case '/':
                stack.push(stack.pop() / val);
                break;
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
