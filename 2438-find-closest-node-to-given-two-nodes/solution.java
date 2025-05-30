class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] dist1 = bfs(edges, node1);
        int[] dist2 = bfs(edges, node2);

        // for(int i : dist1) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // for(int i : dist2) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();

        int min = Integer.MAX_VALUE;
        int node = 0;

        for (int i = 0; i < dist1.length; i++) {
            if(dist1[i] != -1 && dist2[i] != -1) {
                int temp = Math.max(dist1[i], dist2[i]);
                if(min > temp) {
                    min = temp;
                    node = i;
                }
            }
        }

        if(min == Integer.MAX_VALUE)
            return -1;

        return node;
    }

    private int[] bfs(int[] edges, int start) {
        int[] distance = new int[edges.length];
        Arrays.fill(distance, -1);

        boolean[] visited = new boolean[edges.length];
        Queue<Integer> q = new LinkedList<>();

        int dist = 0;

        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                int ele = q.poll();
                distance[ele] = dist;
                visited[ele] = true;
                if (edges[ele] == -1) {
                    size--;
                    continue;
                }
                if (!visited[edges[ele]]) {
                    q.add(edges[ele]);
                }
                size--;
            }

            dist++;
        }

        return distance;
    }
}
