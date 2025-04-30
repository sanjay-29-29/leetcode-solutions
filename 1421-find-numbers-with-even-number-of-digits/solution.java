class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums) {
            // System.out.println((int) Math.log10(10));
            if(( (int) Math.log10(i) + 1) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
