class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] retArr = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(nums2[0]);
        int index = 1;

        while (index < nums2.length) {
            if(stack.isEmpty()){
                stack.push(nums2[index]);
                index++;
            }
            else if (nums2[index] > stack.peek()) {
                int val = stack.pop();
                //System.out.println(val);
                map.put(val, nums2[index]);
            } else {
                stack.push(nums2[index]);
                index++;
            }
        }

        // for(int val : map.keySet()){
        //     System.out.println(val);
        // }

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                retArr[i] = map.get(nums1[i]);
            } else {
                retArr[i] = -1;
            }
        }

        return retArr;
    }
}
