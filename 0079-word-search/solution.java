class Solution {
    public boolean exist(char[][] board, String word) { 
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(traverse(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean traverse(char[][] board, int i, int j, String word, int index, boolean[][] visited){
        if(index == word.length()){
            return true;
        }

        if(!(0 <= i && i < board.length) || !(0 <= j && j < board[0].length)){
            return false;
        }

        if(visited[i][j]){
            return false;
        }

        if(word.charAt(index) == board[i][j]){
            visited[i][j] = true;
            boolean res = traverse(
                board, i + 1, j, word, index + 1, visited
            ) || traverse(
                board, i, j + 1, word, index + 1, visited
            ) || traverse(
                board, i - 1, j, word, index + 1, visited
            ) || traverse(
                board, i, j - 1, word, index + 1, visited
            );
            visited[i][j] = false;
            return res;
        }

        return false;
    }
}
