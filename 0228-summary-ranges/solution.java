class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while(i < nums.length){
            String curr = String.valueOf(nums[i]);
            int temp = nums[i];
            int j = i + 1;

            boolean flag = false;
            String next = "";

            while(j < nums.length && (nums[j] - 1 == temp)) {
                temp = nums[j];
                flag = true;
                j++;
            }
            if(flag){
                curr += "->"+temp;
            }
            i = j;
            list.add(curr);
        }

        return list;
    }
}
