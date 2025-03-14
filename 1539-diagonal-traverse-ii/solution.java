class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int size = 0;

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            size += list.size();
            for (int j = 0; j < list.size(); j++) {
                int sum = i + j;
                List<Integer> l = map.getOrDefault(sum, new ArrayList<>());
                l.add(list.get(j));
                map.put(sum, l);
            }
        }

        int[] res = new int[size];
        int k = 0;

        for (List<Integer> l : map.values()) {
            Collections.reverse(l);
            for (int i : l) {
                res[k++] = i;
            }
        }

        return res;
    }
}
