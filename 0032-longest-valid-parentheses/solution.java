class Solution {
    class Helper {
        char c;
        int index;

        Helper(char _c, int _index) {
            c = _c;
            index = _index;
        }
    }

    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];

        Stack<Helper> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    Helper h = stack.pop();
                    arr[h.index] = 1;
                    arr[i] = 1;
                }
            } else {
                stack.push(new Helper('(', i));
            }
        }

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        int left = 0, right = 0, max = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                int j = i;
                while(j < arr.length && arr[j] == 1){
                    j++;
                }
                max = Math.max(j - i + 1, max);
                i = j;
            }
        }

        if (max == 0) {
            return max;
        }
        return max - 1;
    }
}
