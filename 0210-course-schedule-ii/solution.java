class Solution {
    private boolean isCyclic(int[][] adj, int courseNo, boolean[] visited, List<Integer> list, Set<Integer> set){
        if(visited[courseNo] == true){
            return true;
        }

        if(set.contains(courseNo)){
            return false;
        }

        visited[courseNo] = true;
        set.add(courseNo);
        for(int i = 0; i < adj.length; i++){
            if(adj[courseNo][i] == 1 && isCyclic(adj, i, visited, list, set)){
                return true;
            }
        }
        list.add(courseNo);
        visited[courseNo] = false;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] arr) {
        int[][] adj = new int[numCourses][numCourses];
        int[] res = new int[numCourses];
        Set<Integer> set = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < arr.length; i++){
            adj[arr[i][0]][arr[i][1]] = 1;
        }

        for(int i = 0; i < numCourses; i++){
            if(isCyclic(adj, i, visited, list, set)){
                return new int[0];
            }
        }
        int k = 0;
        for(int i : list){
            res[k++] = i;
        }
        return res;
    }
}
