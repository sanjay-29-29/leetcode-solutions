class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max = ranks[0];

        for (int i = 1; i < ranks.length; i++) {
            max = Math.max(max, ranks[i]);
        }

        long right = 9223372036854775807l;
        long left = 1;

        while (left < right) {
            long mid = (left + right) / 2;
            long numberOfCars = 0;
            //System.out.println(mid);

            for (int i = 0; i < ranks.length; i++) {
                numberOfCars += Math.floor(Math.sqrt(mid / ranks[i]));
                if(numberOfCars >=  cars){
                    break;
                }
            }
            
            if(numberOfCars >= cars){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }
}
