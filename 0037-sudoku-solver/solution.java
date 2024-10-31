class Solution {
    char[][] board;

    List<Set<Character>> colSet = new ArrayList<>();
    List<Set<Character>> rowSet = new ArrayList<>();
    List<Set<Character>> subGridSet = new ArrayList<>();

    private boolean isValid(int i, int j, char c) {
        int subGridIndex = (i / 3) * 3 + (j / 3);
        if (rowSet.get(i).contains(c) || colSet.get(j).contains(c) || subGridSet.get(subGridIndex).contains(c)){
            return false;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < 9; i++) {
            colSet.add(new HashSet<>());
            rowSet.add(new HashSet<>());
            subGridSet.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int subGridIndex = (i / 3) * 3 + (j / 3);
                rowSet.get(i).add(board[i][j]);
                colSet.get(j).add(board[i][j]);
                subGridSet.get(subGridIndex).add(board[i][j]);
            }
        }

        backTrack(0, 0);
    }

    private boolean backTrack(int i, int j) {
        if (i == 9) {
            return true;
        }

        if (j == 9) {
            return backTrack(i + 1, 0);
        }

        if (board[i][j] != '.') {
            return backTrack(i, j + 1);
        }

        int subGridIndex = (i / 3) * 3 + (j / 3);

        Set<Character> row = rowSet.get(i);
        Set<Character> col = colSet.get(j);
        Set<Character> subGrid = subGridSet.get(subGridIndex);

        for (int k = 1; k <= 9; k++) {
            char c = (char) (k + 48);
            if (isValid(i, j, c)) {
                board[i][j] = c;

                row.add(c);
                col.add(c);
                subGrid.add(c);

                if (backTrack(i, j + 1)) {
                    return true;
                }

                row.remove(c);
                col.remove(c);
                subGrid.remove(c);

                board[i][j] = '.';
            }
        }

        return false;
    }
}
