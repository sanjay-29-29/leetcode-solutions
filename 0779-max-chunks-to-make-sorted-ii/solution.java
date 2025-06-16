class Solution {
    public int maxChunksToSorted(int[] arr) {
        int sum1 = 0, sum2 = 0, chunk = 0;
        int[] arrCopy = new int[arr.length];


        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        Arrays.sort(arrCopy);

        for(int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += arrCopy[i];

            if(sum1 == sum2) chunk++;
        }

        return chunk;
    }
}
