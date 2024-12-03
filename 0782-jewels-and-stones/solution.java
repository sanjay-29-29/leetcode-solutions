class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        String[] jewel = jewels.split("");
        String[] stone = stones.split("");

        int count = 0;

        for(int i = 0; i < stone.length; i++){
            for(int j = 0; j < jewel.length; j++){
                if(stone[i].equals(jewel[j])){
                    count++;
                }
                // break;
            }
        }

        return count;
    }
}
