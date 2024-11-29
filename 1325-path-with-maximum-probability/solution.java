class Solution {
    class Node {
        int vertex;
        double weight;

        Node(int _vertex, double _weight) {
            vertex = _vertex;
            weight = _weight;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((v2, v1) -> Double.compare(v1.weight, v2.weight));
        Map<Integer, List<Node>> adjList = new HashMap<>();
        double[] distances = new double[n];

        Arrays.fill(distances, Double.MIN_VALUE);
        distances[start_node] = 0;

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
            adjList.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
        }

        maxHeap.add(new Node(start_node, 1));

        while (!maxHeap.isEmpty()) {
            Node currNode = maxHeap.remove();

            if (currNode.vertex == end_node) {
                return currNode.weight;
            }

            List<Node> nodeList = adjList.get(currNode.vertex);

            for (Node node : nodeList) {
                if (currNode.weight * node.weight > distances[node.vertex]) {
                    distances[node.vertex] = currNode.weight * node.weight;
                    maxHeap.add(new Node(node.vertex, distances[node.vertex]));
                }
            }
        }

        return 0;
    }
}
