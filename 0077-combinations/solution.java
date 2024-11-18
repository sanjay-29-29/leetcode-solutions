class Solution {
    List<List<Integer>> returnList = new ArrayList<List<Integer>>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recursion(1, 1, new ArrayList<>());
        return returnList;
    }

    private boolean recursion(int index, int currVal, List<Integer> list){
        if(index > k){
            returnList.add(list);
            return true;
        }

        if(currVal > n){
            return false;
        }

        List<Integer> newList = new ArrayList<>(list);
        newList.add(currVal);

        if(recursion(index + 1, currVal + 1, newList)){
            return recursion(index, currVal + 1, new ArrayList<>(list));
        }

        return recursion(index, currVal + 1, new ArrayList<>(list));
    }
}
