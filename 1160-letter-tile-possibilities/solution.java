class Solution {
    public void generatePerms(String str, String curr, int index, Set<Map<Character, Integer>> set) {
        if (index > str.length() - 1) {
            set.add(freqMap(curr));
            return;
        }
        generatePerms(str, curr + str.charAt(index), index + 1, set);
        generatePerms(str, curr, index + 1, set);
    }

    public int calcFactorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * calcFactorial(n - 1);
    }

    public Map<Character, Integer> freqMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map; 
    }

    public int numTilePossibilities(String tiles) {
        Set<Map<Character, Integer>> set = new HashSet<>();
        generatePerms(tiles, "", 0, set);
        int count = 0;
     
        for(Map<Character, Integer> str : set){
            int curr = 0;

            for(int temp : str.values()){
                curr += temp;
            }

            curr = calcFactorial(curr);

            for(int i : str.values()){
                curr /= calcFactorial(i);
            }

            count += curr;
        }

        return count - 1;
    }
}
