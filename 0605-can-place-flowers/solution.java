class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 1) {
            if (n > 0 && flowerbed[0] != 0) {
                return false;
            }
            return true;
        }

        if (flowerbed.length == 2) {
            if (n == 1 && flowerbed[0] == 0 && flowerbed[1] == 0)
                return true;
            return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    n--;
                }
            } 
            else if(i == flowerbed.length - 1) {
                if(flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        if (n <= 0) {
            return true;
        }
        return false;
    }
}
