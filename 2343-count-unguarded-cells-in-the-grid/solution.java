class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];

        for(int i = 0; i < walls.length; i++){
            arr[walls[i][0]][walls[i][1]] = 2;
        }

        for(int i = 0; i < guards.length; i++){
            arr[guards[i][0]][guards[i][1]] = 3;
        }

        for(int i = 0; i < guards.length; i++){
            helper(arr, guards[i][0], guards[i][1]);
        }

        int count = 0;        
        
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0) count++;
            }
       }
        
        return count;
    }

    private void helper(int[][] arr, int x, int y){
        for(int i = y + 1; i < arr[0].length; i++){
            if(arr[x][i] == 2 || arr[x][i] == 3) break;
            arr[x][i] = 1;
        }
        for(int i = y - 1; i >= 0; i--){
            if(arr[x][i] == 2 || arr[x][i] == 3) break;
            arr[x][i] = 1;
        }
        for(int i = x + 1; i < arr.length; i++){
            if(arr[i][y] == 2 || arr[i][y] == 3) break;
            arr[i][y] = 1;
        }
        for(int i = x - 1; i >= 0; i--){
            if(arr[i][y] == 2 || arr[i][y] == 3) break;
            arr[i][y] = 1;
        }
    }
}
