class Solution {
    char[][] board;
    String word;
    int[][] visitedArr;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        visitedArr = new int[board.length][board[0].length];
        boolean returnValue = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    returnValue = returnValue || isExist(i, j, 0);
                    if(returnValue){
                        return true;
                    }
                }
            }
        }
        return returnValue;
    }

    private boolean isExist(int i, int j, int index) {
        boolean exp1 = (0 <= i && i < board.length);
        boolean exp2 = (0 <= j && j < board[0].length);

        if (!exp1 || !exp2) {
            return false;
        }

        if (visitedArr[i][j] == 1) {
            return false;
        }

        if (word.charAt(index) == board[i][j]) {
            visitedArr[i][j] = 1;
            index++;
            if (index == word.length()) {
                return true;
            }
            boolean val = isExist(i + 1, j, index) || isExist(i - 1, j, index)
                    || isExist(i, j + 1, index) || isExist(i, j - 1, index);
            if (val == true)
                return val;
            else
                visitedArr[i][j] = 0;
        }
        return false;
    }
}
