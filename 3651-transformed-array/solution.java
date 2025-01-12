class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i];
            if (currVal < 0) {
                currVal = (currVal + i) % nums.length;
                // System.out.println(currVal);
                if(currVal < 0){
                    res[i] = nums[nums.length + currVal];
                }else{
                    res[i] = nums[currVal];
                }
                //res[i] = nums[nums.length + currVal];
            } else {
                currVal = (i + currVal) % nums.length;
                //System.out.println(currVal);
                res[i] = nums[currVal];
            }
        }

        return res;
    }
}
