class Solution {
    class Element<K, V> {
        K key;
        V value;

        Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public String removeOuterParentheses(String s) {
        Stack<Element<Character, Integer>> stack = new Stack<>();
        int depth = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                depth++;
                stack.push(new Element<>(c, depth));
            }
            else if(c == ')') {
                stack.push(new Element<>(c, depth));
                depth--;
            }
        }

        StringBuilder res = new StringBuilder();

        for(Element<Character, Integer> ele : stack) {
            if(ele.value != 1) {
                res.append(ele.key);
            }
        }

        return res.toString();
    }
}
