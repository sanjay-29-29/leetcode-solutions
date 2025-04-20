class Solution {
    public String tictactoe(int[][] moves) {
        int[][][] win = {
                { { 0, 0 }, { 0, 1 }, { 0, 2 } },
                { { 1, 0 }, { 1, 1 }, { 1, 2 } },
                { { 2, 0 }, { 2, 1 }, { 2, 2 } },

                { { 0, 0 }, { 1, 0 }, { 2, 0 } },
                { { 0, 1 }, { 1, 1 }, { 2, 1 } },
                { { 0, 2 }, { 1, 2 }, { 2, 2 } },

                { { 0, 0 }, { 1, 1 }, { 2, 2 } },
                { { 0, 2 }, { 1, 1 }, { 2, 0 } }
        };

        char[][] arr = new char[9][9];

        for(char[] i : arr) {
            Arrays.fill(i, ' ');
        }

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                arr[moves[i][0]][moves[i][1]] = 'X';
            } else {
                arr[moves[i][0]][moves[i][1]] = 'O';
            }
        }

        String res = "Draw";

        outer : for(int i = 0; i < win.length; i++) {
            char prev = arr[win[i][0][0]][win[i][0][1]];
            int count = 1; 

            if(prev == ' ') {
                continue;
            }

            for(int j = 1; j < win[0].length; j++) {
                if(arr[win[i][j][0]][win[i][j][1]] == prev) {
                    count++;
                }else{
                    continue outer;
                }
            }

            if(count == 3) {
                if(prev == 'O') {
                    res = "B";
                }else{
                    res = "A";
                }
            }
        }

        if(res.equals("Draw") && moves.length != 9) {
            return "Pending";
        }
        return res;
    }
}
