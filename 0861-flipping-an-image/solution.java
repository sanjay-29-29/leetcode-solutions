class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image.length / 2; j++){
                int temp = image[i][j]; 
                image[i][j] = image[i][image.length - j - 1];
                image[i][image.length - j - 1] = temp;
            }
        }

        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image.length ; j++){
                image[i][j] = image[i][j] ^ 1;
            }
        }

        return image;
    }
}
