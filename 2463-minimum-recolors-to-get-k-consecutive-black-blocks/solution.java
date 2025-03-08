class Solution {
    public int minimumRecolors(String s, int k) {
        int left = 0;
        int right = 0;

        int count = 0;
        int flip = 0;
        int minFlip = 9999;

        while(left < s.length() && right < s.length()){
            if(s.charAt(right) == 'W'){
                count++;
                flip++;
                right++;
            }else{
                count++;
                right++;
            }

            if(count == k){
                minFlip = Math.min(minFlip, flip);
                if(s.charAt(left) == 'W'){
                    flip--;
                }
                count--;
                left++;
            }
        }

        return minFlip; 
    }
}
