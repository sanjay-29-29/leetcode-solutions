class Solution {
    class Element{
        int ele;
        int idx;

        Element(int _ele, int _idx){
            ele = _ele;
            idx = _idx;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Element> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        int i = 0;

        while(i < temperatures.length){
            if(stack.isEmpty()){
                stack.push(new Element(temperatures[i], i));
            }
            else if(stack.peek().ele < temperatures[i]){
                Element e = stack.pop();
                res[e.idx] = i - e.idx;
                continue;
            }
            else{
                stack.push(new Element(temperatures[i], i));
            }
            i++;
        }

        return res;
    }
}
