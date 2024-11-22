class Solution {
    public boolean judgeCircle(String s) {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 'U') up++;
            if(s.charAt(i) == 'D') down++;
            if(s.charAt(i) == 'L') left++;
            if(s.charAt(i) == 'R') right++;
        }

        if(left == right && up == down) return true;
        return false;
    }
}
