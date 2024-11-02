class Solution {
    Set<String> set = new HashSet<>();
    char[][] board;

    class Node{
        int i, j;
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public void solve(char[][] board) {
        this.board = board;

        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O')
                dfs(0, i);
            if(board[board.length - 1][i] == 'O')
                dfs(board.length - 1, i);
        }

        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O')
                dfs(i, 0);
            if(board[i][board[0].length - 1] == 'O')
                dfs(i, board[0].length - 1);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j){
        boolean exp1 = (0 <= i && i < board.length);
        boolean exp2 = (0 <= j && j < board[0].length);

        if(!exp1 || !exp2){
            return;
        }
        if(board[i][j] == 'X' || set.contains(i + " " + j)){
            return;
        }
        
        board[i][j] = 'S';
        
        set.add(i + " " + j);

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }   
}
