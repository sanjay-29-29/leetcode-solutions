class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int oddCount = 0;
        int evenCount = 0;
        List<Integer> list = new ArrayList<>(); 

        for(char c : map.keySet()){
            int val = map.get(c);
            if(val % 2 == 0) {
                evenCount += val; 
            }
            else{
                list.add(val);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 1; i < list.size(); i++) {
            oddCount += list.get(i) - 1;
        }

        if(list.size() == 0) {
            return evenCount;
        }

        return evenCount + oddCount + list.get(0);
    }
}
