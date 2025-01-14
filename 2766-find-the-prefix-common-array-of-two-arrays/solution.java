class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[A.length];
        int[] res = new int[A.length];

        for(int i = 0; i < A.length; i++){
            freq[A[i] - 1]++;
            freq[B[i] - 1]++;
            
            int count = 0;

            for(int k = 0; k < A.length;k++){
                if(freq[k] == 2){
                    count++;
                }
            }

            res[i] = count;
        }

        return res; 
    }
}
