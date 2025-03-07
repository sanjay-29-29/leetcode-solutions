class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= right; i++) {
            if (prime[i]) {
                continue;
            }
            if((long) i * i > (long)right){
                continue;
            }
            for (int j = i * i; j <= right; j+= i) {
                prime[j] = true;
            }
        }
        
        int[] res = {-1, -1};
        int first = -1, second = -1, temp1 = -1, temp2 = -1;
        int distance = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if(!prime[i] && first == -1){
                temp1 = i;
                first = i;
            }
            else if(!prime[i] && second == -1){
                second = i;
                temp2 = i;
                distance = second - first;
            }
            else if(!prime[i]){
                temp1 = temp2;
                temp2 = i;

                int currDistance = temp2 - temp1;
                if(distance > currDistance){
                    first = temp1;
                    second = temp2;
                    distance = currDistance;
                }
            }
        }

        if(first == -1 || second == -1){
            return res;
        }

        res[0] = first;
        res[1] = second;
        return res;
    }
}
