class Solution {
    List<String> list = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        gen(n * 2, "");
        return list;
    }

    private void gen(int n, String s) {
        if (n == 0) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                }
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        return;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty())
                list.add(s);
            return;
        }
        gen(n - 1, s + ")");
        gen(n - 1, s + "(");
    }
}
