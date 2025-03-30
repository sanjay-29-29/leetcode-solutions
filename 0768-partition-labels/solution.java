class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int[] val = map.get(c);
                val[1] = i;
            } else {
                map.put(c, new int[] { i, i });
            }
        }

        List<int[]> partition = new ArrayList<>(map.values());
        Collections.sort(partition, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        // for (int i = 0; i < partition.size(); i++) {
        //     System.out.println(partition.get(i)[0] + " " + partition.get(i)[1]);
        // }

        int prev = 0;
        int curr = 1;

        while (prev < partition.size() && curr < partition.size()) {
            if (partition.get(prev)[1] >= partition.get(curr)[0]) {
                partition.get(prev)[1] = Math.max(partition.get(curr)[1], partition.get(prev)[1]);
                curr++;
            } else {
                prev++;
                partition.get(prev)[0] = partition.get(curr)[0];
                partition.get(prev)[1] = partition.get(curr)[1];
                curr++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= prev; i++) {
            res.add(partition.get(i)[1] - partition.get(i)[0] + 1);
        }
        
        return res;
    }
}
