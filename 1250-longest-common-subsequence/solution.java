class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int longestCommonSubsequence(String text1, String text2) {
        return recursion(text1, text2, 0, 0);
    }
    
    private int recursion(String text1, String text2, int index1, int index2){
        if(index1 > text1.length() - 1 || index2 > text2.length() - 1){
            return 0;
        }

        String key = index1 + " " + index2;
        int res = map.getOrDefault(key, - 1);
        if(res != -1){
            return res;
        }

        int val1 = 0;
        if(text1.charAt(index1) == text2.charAt(index2)){
            val1 = 1 + recursion(text1, text2, index1 + 1, index2 + 1);
        }

        int val2 = recursion(
            text1, text2, index1 + 1, index2
        );
        int val3 = recursion(
            text1, text2, index1, index2 + 1
        );
        int max = Math.max(
            val1,
            Math.max(
                val2, val3
            )
        );

        map.put(key, max);
        return max;
    }
}
