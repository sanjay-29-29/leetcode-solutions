class Solution {
    List<HashSet<Character>> rowSet = new ArrayList<>();
    List<HashSet<Character>> colSet = new ArrayList<>();
    List<HashSet<Character>> subGridSet = new ArrayList<>();

    private boolean isValid(int i, int j, char c){
        int subGridIndex = (i / 3) + (j / 3) * 3;

        HashSet<Character> row = rowSet.get(i);
        HashSet<Character> col = colSet.get(j);
        HashSet<Character> subGrid = subGridSet.get(subGridIndex);
        
        if(row.contains(c) || col.contains(c) || subGrid.contains(c)){
            return false;
        }

        row.add(c);
        col.add(c);
        subGrid.add(c);
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            rowSet.add(new HashSet<>());
            colSet.add(new HashSet<>());
            subGridSet.add(new HashSet<>());
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(!isValid(i, j, board[i][j])){
                    return false;
                }        
            }
        }

        return true;       
    }
}
