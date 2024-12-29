class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = piles[0];

        for(int i = 0; i < piles.length; i++){
            right = Math.max(right, piles[i]);
        }

        if(piles.length == h){
            return right;
        }
        
        int left = 1;

        while(left < right){
            int mid = (left + right) / 2;
            int time = 0;

            for(int i = 0; i < piles.length; i++){
                time += Math.ceil((double) piles[i] / mid);
                if(time > h){
                    break;
                }
            }

            //System.out.println(left + " " + right + " " + mid);

            if(time <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }
}
