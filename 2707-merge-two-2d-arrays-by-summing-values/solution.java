class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i][0], map.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
        }
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }


        int[][] res = new int[map.size()][2];

        int j = 0;
        for(int i : map.keySet()){
            res[j][0] = i;
            res[j][1] = map.get(i);
            j++;
        }

        return res;
    }
}
