class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            int val = map.getOrDefault(c, 0);
            if (val != 0) {
                set.add(c);
            }
            for (int j = 0; j < val; j++) {
                res.append(c);
            }
        }

        for (char c : map.keySet()) {
            if (!set.contains(c)) {
                int val = map.get(c);
                for (int i = 0; i < val; i++) {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }
}
