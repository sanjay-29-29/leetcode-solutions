class Solution {
    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder str = new StringBuilder();

                while (!stack.isEmpty()) {
                    char ele = stack.pop();
                    if (ele == '(')
                        break;
                    str.append(ele);
                }

                str.reverse();
                char[] value = calc(str);

                if (!stack.isEmpty() && value[0] == '-' && stack.pop() == '-') {
                    stack.push('+');
                    for (int i = 1; i < value.length; i++)
                        stack.push(value[i]);
                } else {
                    for (int i = 0; i < value.length; i++)
                        stack.push(value[i]);
                }
            }
            else if (c != ' ') {
                stack.push(c);
            }
        }

        StringBuilder str = new StringBuilder();
        for(char i : stack) {
            str.append(i);
        }
        char[] res = calc(str);
        str.delete(0, str.length());
        for(char c : res) {
            str.append(c);
        }
        return Integer.valueOf(str.toString());
    }

    private char[] calc(StringBuilder s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                res = res * 10 + c - '0';
            } else if (c != ' ') {
                doOperation(stack, sign, res);
                sign = c;
                res = 0;
            }
        }

        doOperation(stack, sign, res);
        int val = 0;

        for (int i : stack) {
            val += i;
        }

        return String.valueOf(val).toCharArray();
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
