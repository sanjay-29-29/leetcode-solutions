class Solution {
    public int longestPalindrome(String[] words) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : map.keySet()) {
            StringBuilder temp = new StringBuilder(s);
            temp.reverse();
            String t = temp.toString();

            if (visited.contains(t) || visited.contains(s)) {
                continue;
            }

            boolean a = map.containsKey(t);

            if(s.equals(t)) {
                int val = map.get(t);
                if(val > 1) {
                    if(val % 2 == 0) {
                        res += s.length() * val;
                        visited.add(t);
                    }else {
                        res += s.length() * (val - 1);
                    }
                }
            }
            else if (a) {
                visited.add(t);
                visited.add(s);
                int count = Math.min(map.get(t), map.get(s));
                res += s.length() * 2 * count;
            }
        }
        int mid = 0;
        for (String s : map.keySet()) {
            if (visited.contains(s)) {
                continue;
            }
            StringBuilder temp = new StringBuilder(s);
            temp.reverse();
            String t = temp.toString();
            if (s.equals(t)) {
                mid = Math.max(mid, s.length());
            }
        }

        return res + mid;
    }
}
