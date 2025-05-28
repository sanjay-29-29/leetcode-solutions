class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, List<Integer>> adjList1 = new TreeMap<>();
        Map<Integer, List<Integer>> adjList2 = new TreeMap<>();

        for (int[] i : edges1) {
            List<Integer> list = adjList1.getOrDefault(i[0], new LinkedList<>());
            list.add(i[1]);
            adjList1.put(i[0], list);
            list = adjList1.getOrDefault(i[1], new LinkedList<>());
            list.add(i[0]);
            adjList1.put(i[1], list);
        }
        for (int[] i : edges2) {
            List<Integer> list = adjList2.getOrDefault(i[0], new LinkedList<>());
            list.add(i[1]);
            adjList2.put(i[0], list);
            list = adjList2.getOrDefault(i[1], new LinkedList<>());
            list.add(i[0]);
            adjList2.put(i[1], list);
        }

        // int[] maxDist1 = new int[adjList1.size()];
        // int[] maxDist2 = new int[adjList2.size()];
        int[] res = new int[adjList1.size()];

        int j = 0;

        for (int i : adjList1.keySet()) {
            res[j++] += maxNodes(adjList1, i, k);
        }
        if (k == 0) {
            return res;
        }
        int max = 0;
        for (int i : adjList2.keySet()) {
            max = Math.max(max, maxNodes(adjList2, i, k - 1));
        }

        for(int i = 0; i < res.length; i++) {
            res[i] += max;
        }

        return res;
    }

    private int maxNodes(Map<Integer, List<Integer>> adjList, int start, int maxDist) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int dist = 0;

        q.add(start);

        while (!q.isEmpty()) {
            if (dist > maxDist) {
                break;
            }
            int size = q.size();
            while (size > 0) {
                int a = q.poll();
                if (visited.contains(a)) {
                    size--;
                    continue;
                }
                visited.add(a);
                for (int i : adjList.getOrDefault(a, new LinkedList<>())) {
                    q.add(i);
                }
                size--;
            }
            // System.out.println(maxDist + " " + dist);
            dist++;
        }

        return visited.size();
    }
}
