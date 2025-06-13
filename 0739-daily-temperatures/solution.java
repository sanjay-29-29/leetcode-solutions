class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return key + " " + value;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] res = new int[temp.length];
        int i = 0;

        while (i < temp.length) {
            if (stack.isEmpty()) {
                stack.push(i);
                i++;
            }
            else { 
                while(!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                    int ele = stack.pop();
                    res[ele] = i - ele; 
                }
                stack.push(i++);
            }
        }

        return res;
    }
}
