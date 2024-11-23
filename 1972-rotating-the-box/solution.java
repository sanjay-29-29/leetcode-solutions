class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int count = 0;
        int lastBox = Integer.MAX_VALUE;
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[0].length; j++){
                if(box[i][j] == '#'){
                    lastBox = Math.min(lastBox, j);
                    count++;
                }
                else if(box[i][j] == '.' && count > 0){
                    for(int k = j; k >= lastBox + 1; k--){
                        char temp = box[i][k];
                        box[i][k] = box[i][k - 1];
                        box[i][k - 1] = temp;
                    }
                }
                else if(box[i][j] == '*'){
                    lastBox = Integer.MAX_VALUE;
                    count = 0;
                }
            }
        }

        char[][] newBox = new char[box[0].length][box.length];

        for(int i = 0; i < newBox.length; i++){
            for(int j = 0; j < newBox[0].length; j++){
                newBox[i][j] = box[box.length - 1 - j][i];
            }
        }

        return newBox;
    }
}
