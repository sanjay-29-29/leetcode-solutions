class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = candies[0];

        for(int i : candies){
            max = Math.max(max, i);
        }
        
        int res = 0;
        int left = 1, right = max;

        while(left <= right){
            int mid = (left + right) / 2;
            if(canGet(candies, mid, k)){
                res = Math.max(mid, res);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return res;
    }

    private boolean canGet(int[] candies, int splitCount, long children){
        long count = 0;    
        for(int candy : candies){
            if(candy >= splitCount){
                count += candy / splitCount;
            }
            if(count >= children){
                // System.out.println(count + " " + splitCount);
                return true;
            }
        }

        // System.out.println(count + " " + splitCount);
        return false;
    }
}
