class Solution {
    int[][] matrix;
    Map<String, Integer> map = new HashMap<>();

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(traverse(i, j, Integer.MIN_VALUE), max);
            }
        }

        return max;
    }

    private int traverse(int i, int j, int prevVal){
        boolean exp1 = (0 <= i && i < matrix.length);
        boolean exp2 = (0 <= j && j < matrix[0].length);

        String key = i + " " + j;

        if(!exp1 || !exp2){
            return 0;
        }


        if(matrix[i][j] > prevVal){
            if(map.containsKey(key)){
                return map.get(key);
            }
            int val = 1 + Math.max(
                traverse(i + 1, j, matrix[i][j]),
                Math.max(
                    traverse(i - 1, j, matrix[i][j]),
                    Math.max(
                        traverse(i, j + 1, matrix[i][j]),
                        traverse(i, j - 1, matrix[i][j])
                    )
                ));
            map.put(key, val);
            return val;
        }

        return 0;
    }
}
