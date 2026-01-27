class Solution {
    class Node {
        int cost, edge;

        Node(int edge, int cost) {
            this.edge = edge;
            this.cost = cost;
        }

        // public int hashCode() {
        //     return 10 * cost + edge;
        // }

        // public boolean equals(Object o) {
        //     if(!(o instanceof Node)) {
        //         return false;
        //     }

        //     Node n = (Node)o;

        //     if(n.cost != this.cost || n.edge != this.edge) {
        //         return false;
        //     }

        //     return true;
        // }
    }

    public int minCost(int n, int[][] edges) {
        Map<Integer, List<Node>> adjList = new HashMap<>();

        for (int i[] : edges) {
            List<Node> set1 = adjList.getOrDefault(i[0], new LinkedList<>());
            List<Node> set2 = adjList.getOrDefault(i[1], new LinkedList<>());

            set1.add(new Node(i[1], i[2]));
            set2.add(new Node(i[0], 2 * i[2]));

            adjList.put(i[0], set1);
            adjList.put(i[1], set2);
        }

        return dijkstra(n, adjList);
    }

    private int dijkstra(int n, Map<Integer, List<Node>> adjList) {
        boolean[] visited = new boolean[n];

        Queue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        pq.offer(new int[] { 0, 0 });

        while(!pq.isEmpty()) {
            int[] val = pq.poll();

            if(val[0] == n - 1) {
                return val[1];
            }

            if(visited[val[0]] == true) {
                continue;
            }

            List<Node> nodes = adjList.get(val[0]);
            visited[val[0]] = true;

            if(nodes == null) continue;

            for(Node node : nodes) {
                pq.offer(new int[] {node.edge, val[1] + node.cost});
            }
        }

        return -1;
    }
}
