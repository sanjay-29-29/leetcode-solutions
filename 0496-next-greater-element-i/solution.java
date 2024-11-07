class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] returnList = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){
            boolean found = false;
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j] ){
                    found = true;
                    continue;
                }
                if(found && nums2[j] > nums1[i]){
                    returnList[i] = nums2[j];
                    break;
                }    
            }
            if(returnList[i] == 0){
                returnList[i] = -1;
            }
        }

        return returnList;
    }
}
