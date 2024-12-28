class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> Hmap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < strs[i].length(); j++) {
                if (map.containsKey(strs[i].charAt(j))) {
                    map.put(strs[i].charAt(j), map.get(strs[i].charAt(j)) + 1);
                } else {
                    map.put(strs[i].charAt(j), 1);
                }
            }

            if (Hmap.containsKey(map)) {
                List<String> list = Hmap.get(map);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>(); 
                list.add(strs[i]);
                Hmap.put(map, list);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for (List<String> l : Hmap.values()) {
            list.add(l);
        }

        return list;
    }
}
