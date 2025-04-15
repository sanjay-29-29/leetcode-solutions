class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        char[][] arr = new char[numRows][s.length()];
        for(char[] i : arr) {
            Arrays.fill(i, ' ');
        }

        int row = 0, col = 0;
        int i = 0;
        while(i < s.length()) {
            while(row < numRows && i < s.length()) {
                arr[row][col] = s.charAt(i);
                row++;
                i++;
            }

            row = numRows - 2;
            col++;

            while(row >= 0 && i < s.length()) {
                arr[row][col] = s.charAt(i);
                row--;
                col++;
                i++;
            }

            row = 1;
            col = col - 1;
            // col = col - 1;
        }

        StringBuilder res = new StringBuilder();

        for(i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++) {
                // System.out.print(arr[i][j]);
                if(arr[i][j] != ' ') {
                    res.append(arr[i][j]);
                }
            }
            // System.out.println();
        }

        return res.toString();
    }
}
