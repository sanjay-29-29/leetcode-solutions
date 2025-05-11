class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();
            
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                List<Integer> list = map.getOrDefault((j - i), new ArrayList<>());
                list.add(mat[i][j]);
                map.put((j - i), list);
            }
        }
        
        for(List<Integer> l : map.values()) {
            // System.out.println(l);
            Collections.sort(l);
        }

        Map<Integer, Integer> newM = new HashMap<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                int idx = newM.getOrDefault(j - i, 0);
                List<Integer> l = map.get(j - i);
                mat[i][j] = l.get(idx);
                newM.put(j - i, idx + 1);
            }
        }

        return mat;

    }
}
