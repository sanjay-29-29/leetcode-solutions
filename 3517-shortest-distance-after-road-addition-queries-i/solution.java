class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[][] adjList = new int[n][n];
        int[] retArray = new int[queries.length];

        for (int i = 0; i < n - 1; i++) {
            adjList[i][i + 1] = 1;
        }

        for (int i = 0; i < queries.length; i++) {
            adjList[queries[i][0]][queries[i][1]] = 1;
            retArray[i] = traverse(adjList);
        }

        return retArray;
    }

    private int traverse(int[][] adjList) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[adjList.length];
        boolean[] visited = new boolean[adjList.length];

        queue.add(0);

        while (!queue.isEmpty()) {
            int currNode = queue.remove();
            
            for (int i = 0; i < adjList.length; i++) {
                if (adjList[currNode][i] == 1 && !visited[i]) {
                    distance[i] = distance[currNode] + 1;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
        return distance[adjList.length - 1];
    }
}
