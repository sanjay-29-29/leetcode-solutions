class Solution {
    private Map<Character, Integer> calcFreq(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        return map;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character, Integer> gMap = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(int i = 0; i < words2.length; i++){
            Map<Character, Integer> wordMap = calcFreq(words2[i]);
            for(char c : wordMap.keySet()){
                if(gMap.containsKey(c)){
                    int curr = wordMap.get(c);
                    int prev = gMap.get(c);
                    gMap.put(c, Math.max(curr, prev));
                }else{
                    gMap.put(c, wordMap.get(c));
                }
            }
        }


        for(int i = 0; i < words1.length; i++){
            Map<Character, Integer> wordMap = calcFreq(words1[i]);
            boolean flag = false;

            for(Character c : gMap.keySet()){
                if(!wordMap.containsKey(c)){
                    flag = true;
                    break;
                }
                int gMapVal = gMap.get(c);
                int wordVal = wordMap.get(c);

                if(wordVal < gMapVal){
                    flag = true;
                    break;
                }
            }

            if(!flag) res.add(words1[i]);
        }


        return res;
    }
}
