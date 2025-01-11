class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int currCost = 0;
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            int cost = canInclude(s.charAt(right), t.charAt(right));
            currCost += cost;
            while (currCost > maxCost) {
                currCost -= canInclude(s.charAt(left), t.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    private int canInclude(char a, char b) {
        // System.out.println((int)a + " " + (int)b);
        int diff = Math.abs(a - b);
        return diff;
    }
}
