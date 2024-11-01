class Solution {
    List<List<String>> list = new ArrayList<>();
    char[][] ch;

    private boolean isValid(int i, int j) {
        int n = ch.length;

        for (int col = 0; col < n; col++) {
            if (ch[i][col] == 'Q') {
                return false;
            }
        }

        for (int row = 0; row < n; row++) {
            if (ch[row][j] == 'Q') {
                return false;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (ch[row][col] == 'Q') {
                    int deltaRow = Math.abs(i - row);
                    int deltaCol = Math.abs(j - col);
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
            List<String> l = new ArrayList<>();
            for (int k = 0; k < ch.length; k++) {
                String s = "";
                for (int z = 0; z < ch.length; z++) {
                    s += ch[k][z];
                }
                l.add(s);
            }
            list.add(l);
            return true;
        }

        if (j == ch.length) {
            return false;
        }

        if (isValid(i, j)) {
            ch[i][j] = 'Q';
            if(backTrack(i + 1, 0)){
                backTrack(i, j + 1);
            }
            ch[i][j] = '.';
            return backTrack(i, j + 1);
        }
        return backTrack(i, j + 1);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] ch = new char[n][n];
        this.ch = ch;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ch[i][j] = '.';
            }
        }
        backTrack(0, 0);
        return list;
    }
}
