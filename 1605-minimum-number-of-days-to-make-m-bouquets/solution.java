class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(((long)m * k) > bloomDay.length) return -1;

        int min = bloomDay[0];
        int max = bloomDay[1];

        for(int i = 0; i < bloomDay.length; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }

        while(min < max){
            int mid = (min + max) / 2;
            int flowerCount = 0;
            for(int i = 0; i < bloomDay.length; i++){
                
                if(bloomDay[i] <= mid){
                    int count = 0;
                    int j = i;

                    while(j < bloomDay.length && bloomDay[j] <= mid){
                        //System.out.print(j + " ");
                        count++;
                        if(count == k){
                            flowerCount++;
                            count = 0;
                        }
                        j++;
                    }
                    i = j;
                }
            }
            //System.out.println();

            //System.out.println(mid + " " + flowerCount);

            if(flowerCount >= m){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return min;
    }
}
