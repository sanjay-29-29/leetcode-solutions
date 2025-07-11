class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> a = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            a.add(c);
        }

        int count = 0;

        outer : for (String s : words) {
            Set<Character> b = new HashSet<>();
            for (char c : s.toCharArray()) {
                b.add(c);
            }
            for(char c : b) {
                if(!a.contains(c)) {
                    continue outer;
                }
            }
            count++;
        }
        return count;
    }
}
