class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int left = j+1;
                int right = nums.length - 1;
                while(left<right){
                    long sum =(long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        if(!list.contains(l)){
                            list.add(l);
                        }
                        left++;
                    }
                    if(target>sum){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
