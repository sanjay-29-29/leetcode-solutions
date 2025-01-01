class Solution {
    public int maxScore(String s) {
        int oneCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                oneCount++;
            }
        }

        int zeroCount = 0;
        int max = 0;
        
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '0'){
                zeroCount++;
            }
            if(s.charAt(i) == '1'){
                oneCount--;
            }
            max = Math.max(max, zeroCount + oneCount);
        }

        return max;
    }
}
