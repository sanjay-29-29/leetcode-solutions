class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();

        Set<Character> set1 = new HashSet(Arrays.asList(
                'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'
        ));
        Set<Character> set2 = new HashSet(Arrays.asList(
                'a', 's', 'd', 'f', 'g', 'j', 'k', 'l', 'h'
        ));
        Set<Character> set3 = new HashSet(Arrays.asList(
                'z', 'x', 'c', 'v', 'b', 'n', 'm'
        ));

        List<Set<Character>> list = new ArrayList<>();

        list.add(set1);
        list.add(set2);
        list.add(set3);

        outer : for(int i = 0; i < words.length; i++) {
            String word = words[i];
            Set<Character> set = null;

            for(int j = 0; j < 3 ;j++) {
                if(list.get(j).contains(word.charAt(0)) || list.get(j).contains((char) (word.charAt(0) + 32))) {
                    set = list.get(j);
                }
            }

            for(int j = 0; j < word.length(); j++) {
                if(!set.contains(word.charAt(j)) && !set.contains((char) (word.charAt(j) + 32))) {
                    continue outer;
                }
            }

            res.add(word);
        }
        
        return res.toArray(new String[0]);
    }
}
