class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int sum = i + j;
                List<Integer> list = map.getOrDefault(sum, new LinkedList<>());
                list.addLast(mat[i][j]);
                map.put(sum, list);
            }
        }

        List<Integer> res = new ArrayList<>();
        int k = 0; 
        for(int i : map.keySet()){
            List<Integer> l = map.get(i);
            if(k % 2 == 0){
                Collections.reverse(l);
            }
            k++;
            res.addAll(l);
        }

        int[] arr = new int[res.size()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = res.get(i);
        }

        return arr;
    }
}
