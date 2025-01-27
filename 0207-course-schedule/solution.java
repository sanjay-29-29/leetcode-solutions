class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        int[][] adj = new int[numCourses][numCourses];
        boolean[] visited = new boolean[numCourses];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            adj[arr[i][0]][arr[i][1]] = 1;
        }

        // for(int[] i : adj){
        //     for(int j : i){
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < adj.length; i++) {
            if (checkCycle(adj, i, visited, set)) {
                return false;
            }
            set.add(i);
        }

        return true;
    }

    private boolean checkCycle(int[][] arr, int courseNo, boolean[] visited, Set<Integer> set) {
        if(visited[courseNo] == true){
            return true;
        }

        if(set.contains(courseNo)){
            return false;
        }

        visited[courseNo] = true;
        boolean res = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[courseNo][i] == 1){
                res = res || checkCycle(arr, i, visited, set);
                if(res == true){
                    return true;
                }
                set.add(i);
            } 
        }
        visited[courseNo] = false;
        return res;
    }
}
