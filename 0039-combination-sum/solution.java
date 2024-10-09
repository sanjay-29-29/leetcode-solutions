class Solution {
    List<List<Integer>> list;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        recursion(candidates, target, l, 0);
        return list;
    }
    
    private void recursion(int[] arr, int target, List<Integer> l, int start){
        if(target == 0){
            list.add(l);
        }
        for(int i=start; i<arr.length;i++){
            if(target-arr[i]>=0){
                List<Integer> l1 = new ArrayList<Integer>();
                l1.addAll(l);
                l1.add(arr[i]);
                recursion(arr,target-arr[i],l1,i);
            }
        }
    }
}
