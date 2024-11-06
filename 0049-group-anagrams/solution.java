class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, Integer> hash = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++){
                if(map.containsKey(strs[i].charAt(j))){
                    map.put(strs[i].charAt(j), map.get(strs[i].charAt(j)) + 1);
                }else{
                    map.put(strs[i].charAt(j), 1);
                }
            }
            if(hash.containsKey(map)){
                int listIndex = hash.get(map);
                List<String> strList = list.get(listIndex);
                strList.add(strs[i]);
            }else{
                hash.put(map, list.size());
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                list.add(newList);
            }
        }

        return list;
    }
}
