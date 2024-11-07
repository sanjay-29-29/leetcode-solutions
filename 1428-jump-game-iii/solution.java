class Solution {
    int[] arr;
    int[] visited;
    Map<Integer, Boolean> map = new HashMap<>();

    public boolean canReach(int[] arr, int start) {
        this.arr = arr;
        this.visited = new int[arr.length];

        return recursion(start);
    }   

    private boolean recursion(int index){
        boolean exp = (0 <= index && index < arr.length);
        
        if(!exp || visited[index] == 1){
            return false;
        }

        if(map.containsKey(index)){
            return map.get(index);
        }

        if(arr[index] == 0){
            return true;
        }
        visited[index] = 1;
        boolean res = recursion(index + arr[index]) || recursion(index - arr[index]);
        visited[index] = 0;
        map.put(index, res);
        return res;
    }
}
