class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = 0;
        int n2 = 0;

        Set<Integer> list = new HashSet<>();

        while(n1 < nums1.length && n2 < nums2.length) {
            if(nums1[n1] == nums2[n2]){
                list.add(nums1[n1]);
                n1++;
                n2++;
            }
            else if(nums1[n1] > nums2[n2]){
                n2++;
            }else{
                n1++;
            }
        }
        
        int[] array = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            array[i] = it.next();
            i++;
        }
        return array;
    }
}
