class Solution {
    int[][] graph;
    int[] visited;
    List<List<Integer>> returnList = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        this.visited = new int[graph.length];

        backTrack(0, new ArrayList<>());
        
        return returnList;
    }

    private void backTrack(int index, List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list);

        if (index == graph.length - 1) {
            newList.add(index);
            returnList.add(newList);
            return;
        }

        if (visited[index] == 1) {
            return;
        }

        newList.add(index);
        visited[index] = 1;

        for (int i = 0; i < graph[index].length; i++) {
            backTrack(graph[index][i], newList);
        }

        visited[index] = 0;
    }
}
