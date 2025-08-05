class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] vis = new boolean[baskets.length];
        int res = baskets.length;

        for(int i = 0; i < fruits.length; i++) {
            for(int j = 0; j < fruits.length; j++) {
                if(!vis[j] && fruits[i] <= baskets[j]) {
                    vis[j] = true;
                    res--;
                    break;
                }
            }
        }

        return res;
    }
}
