import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initialize data structures to track the seen elements in rows, columns, and subgrids
        HashSet<String>[] rows = new HashSet[9];
        HashSet<String>[] cols = new HashSet[9];
        HashSet<String>[] subgrids = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            subgrids[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];
                
                if (currentVal != '.') {
                    String val = Character.toString(currentVal);

                    // Check row
                    if (rows[i].contains(val)) {
                        return false;
                    }
                    rows[i].add(val);

                    // Check column
                    if (cols[j].contains(val)) {
                        return false;
                    }
                    cols[j].add(val);

                    // Calculate subgrid index
                    int subgridIndex = (i / 3) * 3 + j / 3;
                    if (subgrids[subgridIndex].contains(val)) {
                        return false;
                    }
                    subgrids[subgridIndex].add(val);
                }
            }
        }
        return true;
    }
}

