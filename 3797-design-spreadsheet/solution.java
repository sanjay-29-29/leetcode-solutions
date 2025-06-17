class Spreadsheet {
    int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows + 1][27];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.valueOf(cell.substring(1, cell.length()));
        sheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.valueOf(cell.substring(1, cell.length()));
        sheet[row][col] = 0;
    }

    public int getValue(String formula) {
        int i = 1;
        StringBuilder a1 = new StringBuilder();
        StringBuilder a2 = new StringBuilder();

        while (formula.charAt(i) != '+') {
            a1.append(formula.charAt(i++));
        }
        i++;
        while (i < formula.length() && formula.charAt(i) != '+') {
            a2.append(formula.charAt(i++));
        }

        // System.out.println(a1 + " " + a2);

        return parse(a1) + parse(a2);
    }

    public int parse(StringBuilder s) {
        if('0' <= s.charAt(0) && s.charAt(0) <= '9') {
            return Integer.valueOf(s.toString());
        }
        int col = s.charAt(0) - 'A';
        int row = Integer.valueOf(s.substring(1, s.length()));
        return sheet[row][col];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
