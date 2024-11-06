class Solution {
    List<String> wordDict;
    String s;
    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        this.s = s;
        return recursion("", 0);
    }

    private boolean recursion(String word, int index) {
        if (index == s.length()) {
            if (wordDict.contains(word)) {
                return true;
            }
            return false;
        }
        String key = word + "," + index;

        if(map.containsKey(key)){
            return map.get(key);
        }

        if (wordDict.contains(word)) {           
            boolean val = recursion(String.valueOf(s.charAt(index)), index + 1)
                    || recursion(word + s.charAt(index), index + 1);
            map.put(key, val);
            return val;
        }
        boolean val = recursion(word + s.charAt(index), index + 1);
        map.put(key, val);
        return val;
    }
}
