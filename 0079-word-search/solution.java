class Solution {
    char[][] board;
    String word;
    int[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;    
        this.word = word;
        this.visited = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(traverse(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean traverse(int i, int j, int index){
        boolean exp1 = (0 <= i && i < board.length);
        boolean exp2 = (0 <= j && j < board[0].length);

        if(index == word.length()){
                return true;
        }

        if(!exp1 || !exp2){
            return false;
        }

        if(visited[i][j] == 1){
            return false;
        }

        visited[i][j] = 1;

        if(word.charAt(index) == board[i][j]){
            boolean ret = traverse(i + 1, j, index + 1) ||
                traverse(i - 1, j, index + 1) ||
                traverse(i, j + 1, index + 1) ||
                traverse(i, j - 1, index + 1);
                visited[i][j] = 0;
            return ret;
        }
        visited[i][j] = 0;
        return false;
    }
}
