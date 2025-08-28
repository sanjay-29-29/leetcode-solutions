class Solution {
    public int[][] sortMatrix(int[][] grid) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<Integer> l = map.getOrDefault(j - i, new ArrayList<>());
                l.add(grid[i][j]);
                map.put(j - i, l);
            }
        }

        int k = 0;
        for (int i : map.keySet()) {
            List<Integer> l = map.get(i);
            if(k < grid[0].length) {
                Collections.sort(l, Collections.reverseOrder());
            }else {
                Collections.sort(l);
            }
            k++;
        }

        Map<Integer, Integer> iMap = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int idx = iMap.getOrDefault(j - i, 0);
                List<Integer> l = map.get(j - i);
                grid[i][j] = l.get(idx++);
                iMap.put(j - i, idx);
            }
        }

        return grid;
    }
}
