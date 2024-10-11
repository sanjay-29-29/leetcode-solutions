class Solution {
    List<List<Integer>> list;

    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        recursion(l,0,n,k,1);
        return list;
    }
    
    private void recursion(List<Integer> l, int current, int sum, int max, int index){
        if(l.size() == max && sum==0 && !list.contains(l)){
            list.add(l);
            return;
        }
        for(int i=index;i<=9;i++){
            if(sum - i >= 0){
                List<Integer> newList = new ArrayList<Integer>();
                newList.addAll(l);
                newList.add(i);
                recursion(newList, current+1, sum-i, max, i+1);
            }
        }
    }
}
