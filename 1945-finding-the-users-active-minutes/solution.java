class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < logs.length; i++) {
            Set<Integer> set = map.getOrDefault(logs[i][0], new HashSet<>());
            set.add(logs[i][1]);
            map.put(logs[i][0], set);
        }

        Map<Integer, Integer> newM = new HashMap<>();

        for(int i : map.keySet()) {
            Set<Integer> s = map.get(i);
            newM.put(
                s.size(), newM.getOrDefault(s.size(), 0) + 1
            );
        }

        for(int i : newM.keySet()) {
            res[i - 1] = newM.get(i);
        }

        return res;
    }
}
