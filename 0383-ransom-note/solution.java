class Solution {
    private Map<Character, Integer> createFreqMap(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        return map;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteMap = createFreqMap(ransomNote);
        Map<Character, Integer> magazineMap = createFreqMap(magazine);

        for(char c  : ransomNoteMap.keySet()){
            if(!magazineMap.containsKey(c)){
                return false;
            }
            int ransomNoteFreq = ransomNoteMap.get(c);
            int magazineFreq = magazineMap.get(c);

            if(ransomNoteFreq > magazineFreq){
                return false;
            }
        }

        return true;
    }
}
