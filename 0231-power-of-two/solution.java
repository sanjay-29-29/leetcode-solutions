class Solution {
    public boolean isPowerOfTwo(int n) { 
        if(n < 0){
            return false;
        }
        int count = 0;
        for(int i = 0; i < 31; i++){
            count += n & 1;
            n = n >> 1;
        }

        if(count == 1){
            return true;
        }

        return false;
    }
}
