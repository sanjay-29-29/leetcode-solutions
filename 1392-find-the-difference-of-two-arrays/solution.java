class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(int i : set1){
            if(!set2.contains(i)){
                list1.add(i);
            }    
        }

        for(int i : set2){
            if(!set1.contains(i)){
                list2.add(i);
            }    
        }
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        l.add(list1);
        l.add(list2);
        return l;
    }
}
