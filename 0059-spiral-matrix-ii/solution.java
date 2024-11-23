class Solution {
    public int[][] generateMatrix(int n) {
        int i = 0, j = 0;
        int count = 1;
        Set<String> set = new HashSet<>();

        int[][] matrix = new int[n][n];

        while(count <= n * n){
            while(i < n && j < n && !set.contains(i + " " + j)){
                set.add(i + " " + j);
                matrix[i][j] = count;
                count++;
                j++;
            }

            j = j - 1;
            i = i + 1;
            
            while(i < n && j < n && !set.contains(i + " " + j)){
                set.add(i + " " + j);
                matrix[i][j] = count;
                count++;
                i++;
            }

            i = i - 1;
            j = j - 1;
            
            while(i < n && j >= 0 && !set.contains(i + " " + j)){
                set.add(i + " " + j);
                matrix[i][j] = count;
                count++;
                j--;    
            }

            i = i - 1;
            j = j + 1;
            
            while(i >= 0 && j < n && !set.contains(i + " " + j)){
                set.add(i + " " + j);
                matrix[i][j] = count;
                count++;
                i--;
            }

            i = i + 1;
            j = j + 1;
        }

        return matrix;
    }
}
