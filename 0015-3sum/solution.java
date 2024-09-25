class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hSet = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length - 1;
            
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> l  = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    hSet.add(l);
                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        list.addAll(hSet);
        return list;
    }
}
