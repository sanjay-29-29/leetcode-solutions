class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;

        for (char c : map.keySet()) {
            int freq = map.get(c);
            // System.out.println
            if (freq > 2) {
                if(freq % 2 == 0){
                    count += 2;
                }else{
                    count += 1;
                }
            }else{
                count += freq;
            }
        }

        return count;
    }
}
