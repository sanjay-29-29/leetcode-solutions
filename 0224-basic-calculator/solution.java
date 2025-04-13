class Solution {
    public int calculate(String s) {
        return calc(s);
    }

    public int calc(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                StringBuilder str = new StringBuilder();
                char c = stack.pop();
                while (c != '(') {
                    str.append(c);
                    c = stack.pop();
                }
                str.reverse();
                // System.out.println(str);
                String val = evaluate(str.toString());
                int temp = 0; 
                if(!stack.isEmpty()) {
                    c = stack.peek();
                    if(c == '-' && val.charAt(0) == '-') {
                        stack.pop();
                        stack.push('+');
                        temp = 1;
                    }
                    if(c == '+' && val.charAt(0) == '+') {
                        stack.push('+');
                        temp = 1;
                    }
                }

                for (int j = temp; j < val.length(); j++) {
                    stack.push(val.charAt(j));
                }
            } else if(s.charAt(i) != ' '){
                stack.push(s.charAt(i));
            }
        }
        // System.out.println(stack);
        StringBuilder s1 = new StringBuilder();
        for(char c : stack) {
            s1.append(c);
        }
        return Integer.valueOf(
            evaluate(s1.toString())
        );
    }

    private String evaluate(String s) {
        int res = 0, val = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                res = res * 10 + (c - '0');
            } 
            else if (c != ' ') {
                doOperation(stack, sign, res);
                res = 0;
                sign = c;
            }
        }

        doOperation(stack, sign, res);

        for (int i : stack) {
            val += i;
        }
        // System.out.println(val);
        return String.valueOf(val);
    }

    private void doOperation(Stack<Integer> stack, char sign, int val) {
        switch (sign) {
            case '+':
                stack.push(val);
                break;
            case '-':
                stack.push(-val);
                break;
            case '/':
                stack.push(stack.pop() / val);
                break;
            case '*':
                stack.push(stack.pop() * val);
                break;
        }
    }
}
