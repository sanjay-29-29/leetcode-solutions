class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int prevPrev = arr[i];
                int prev = arr[j];
                int count = 0;

                while(findElement(arr, prevPrev + prev)){
                    int temp1 = prevPrev;
                    int temp2 = prev;
                    prevPrev = prev;
                    prev = temp1 + temp2;
                    count++;
                }

                if(count > 0) {
                    max = Math.max(max, count + 2);
                }
            }
        }

        return max;
    }

    private boolean findElement(int[] arr, int ele){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == ele){
                return true;
            }
            if(arr[mid] > ele){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}
