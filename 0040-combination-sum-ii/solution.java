class Solution {
    List<List<Integer>> list;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list = new ArrayList<List<Integer>>();
        List<Integer> l2 = new ArrayList<Integer>();

        Arrays.sort(candidates);
        recursion(candidates,target,l2,0);
        return list;
    }

    private void recursion(int[] arr, int target, List<Integer> l, int start){
        if(target == 0 && !list.contains(l)){
            list.add(l);
            return;
        }

        for(int i=start;i<arr.length;i++){
            if(target-arr[i]<0){
                break;
            }
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            if(target - arr[i] >= 0){
                List<Integer> l2 = new ArrayList<Integer>();
                l2.addAll(l);
                l2.add(arr[i]);
                recursion(arr, target-arr[i], l2, i+1);
            }
        }
        return;
    }
}
