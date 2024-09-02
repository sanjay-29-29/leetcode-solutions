class Solution {
    public boolean increasingTriplet(int[] arr) {
        int fast = 2147483647;
        int slow = 2147483647;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=fast){
                fast = arr[i];
            }else if(arr[i]<=slow){
                slow = arr[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
