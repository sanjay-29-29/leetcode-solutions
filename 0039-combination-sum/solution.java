class Solution {
    Set<List<Integer>> returnList = new HashSet<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        recursion(new ArrayList<>(), 0, target);
        return new ArrayList<>(returnList);
    }

    public void recursion(List<Integer> list, int index, int target){
        if(target == 0){
            returnList.add(list);
        }
        if(index >= candidates.length){
            return;
        }

        if(target - candidates[index] >= 0){
            List<Integer> newList = new ArrayList<>(list);
            newList.add(candidates[index]);
            recursion(newList, index + 1, target - candidates[index]);
            recursion(newList, index, target - candidates[index]);

        }
        recursion(list, index + 1, target);
    }
}
