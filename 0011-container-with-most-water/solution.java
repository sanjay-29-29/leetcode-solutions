class Solution {
    public int maxArea(int[] height) {
        int slow = 0;
        int fast = height.length - 1;
        int max = 0;
        while(slow<height.length && fast>slow){
             int length;
            if(height[slow]>height[fast]){
               length = height[fast];
            }else{
                length = height[slow];
            }
            if(max< (length*(fast-slow))){
                max = length*(fast-slow);
            }
            if(height[slow]>height[fast]){
                fast--;
            }else{
                slow++;
            }
        }
        return max;
    }
}
