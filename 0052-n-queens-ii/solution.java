class Solution {
    char[][] ch;
    int count;

    private boolean isValid(int i, int j) {
        int n = ch.length;

        for (int k = 0; k < n; k++) {
            if (ch[i][k] == 'Q')
                return false;
            if (ch[k][j] == 'Q')
                return false;
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (ch[k][l] == 'Q') {
                    int deltaRow = Math.abs(k - i);
                    int deltaCol = Math.abs(l - j);
                    if (deltaRow == deltaCol) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean backTrack(int i, int j) {
        if (i == ch.length) {
            count++;
            return true;
        }

        if (j == ch.length) {
            return false;
        }

        if (isValid(i, j)) {
            ch[i][j] = 'Q';
            if (backTrack(i + 1, 0)) {
                backTrack(i, j + 1);
            }
            ch[i][j] = '.';
            return backTrack(i, j + 1);
        }
        return backTrack(i, j + 1);
    }

    public int totalNQueens(int n) {
        ch = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ch[i][j] = '.';
            }
        }
        backTrack(0, 0);
        return count;
    }
}
