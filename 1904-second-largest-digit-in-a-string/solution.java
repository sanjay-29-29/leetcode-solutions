class Solution {
    public int secondHighest(String s) {
        int first = -1, second = -1;
        for(char c : s.toCharArray()) {
            if(!('0' <= c && c <= '9')) {
                continue; 
            }
            if(c > first) {
                second = first;
                first = c;
            }
            if(c < first && c > second) {
                second = c;
            }
        }
        if(first == second || second == -1) 
            return -1;
        return second - '0';
    }
}
