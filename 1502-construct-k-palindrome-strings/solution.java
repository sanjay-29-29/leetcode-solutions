class Solution {
    private Map<Character, Integer> calcFreq(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }

    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }

        Map<Character, Integer> freqMap = calcFreq(s);

        int count = 0;
        for(int val : freqMap.values()){
            if(val % 2 != 0){
                count++;
            }
        }
        if(count > k){
            return false;
        }

        return true; 
    }
}
