class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Map<Character, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if(!indexMap.containsKey(s.charAt(i))){
                indexMap.put(s.charAt(i), i);
            }
        }

        for(Character c : map.keySet()){
            int n = map.get(c);
            if(n == 1){
                return indexMap.get(c);
            }
        }

        return -1;
    }
}
