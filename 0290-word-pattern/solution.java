class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> rMap = new HashMap<>();

        String[] words = s.split(" ");
        String[] letter = pattern.split("");

        if(!(words.length == letter.length)){
            return false;
        }

        for (int i = 0; i < letter.length; i++) {
            if(!map.containsKey(letter[i]) && !rMap.containsKey(words[i])) {
                map.put(letter[i], words[i]);
                rMap.put(words[i], letter[i]);
            }else if(map.containsKey(letter[i]) && rMap.containsKey(words[i])) {
                String a = map.get(letter[i]);
                if(!a.equals(words[i])) {
                    return false;
                }
            }else{
                return false;
            }
        }

        return true;
    }
}
