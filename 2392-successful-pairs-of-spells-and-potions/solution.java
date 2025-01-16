class Solution {
    private int isSuccessful(int[] potions, int spells, long success) {
        int left = 0;
        int right = potions.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            long curr = (long) potions[mid] * spells;
            if (curr >= success) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if(left == potions.length - 1){
            if((long) potions[left] * spells >= success){
                return 1;
            }
            return 0;
        }
        return potions.length - left;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int left = 0;
        int right = potions.length - 1;
        int[] res = new int[spells.length];

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            res[i] = isSuccessful(potions, spells[i], success);
        }

        return res;
    }
}
