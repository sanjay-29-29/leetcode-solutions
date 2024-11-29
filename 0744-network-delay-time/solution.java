class Solution {
    class Node {
        int vertex, time;

        Node(int _vertex, int _time) {
            vertex = _vertex;
            time = _time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adjMat = new int[n][n];

        for(int[] arr : adjMat){
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < times.length; i++) {
            adjMat[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k - 1] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>((v1, v2) -> v1.time - v2.time);
        minHeap.add(new Node(k - 1, 0));

        while (!minHeap.isEmpty()) {
            Node currNode = minHeap.remove();
            for (int i = 0; i < n; i++) {
                if(adjMat[currNode.vertex][i] != - 1 && currNode.time + adjMat[currNode.vertex][i] < distance[i]){
                    distance[i] = currNode.time + adjMat[currNode.vertex][i];
                    minHeap.add(new Node(i, distance[i]));
                }
            }
        }

        int max = 0; 
        for(int i = 0; i < n; i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }
        
        return max;
    }
}
