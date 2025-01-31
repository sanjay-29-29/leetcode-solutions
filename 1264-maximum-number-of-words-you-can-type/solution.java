class Solution {
    private boolean contains(Set<Character> set, String word){
        for(int i = 0; i < word.length(); i++){
            if(set.contains(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < brokenLetters.length(); i++){
            set.add(brokenLetters.charAt(i));
        }

        int count = 0;
        String[] split = text.split(" ");

        for(String s : split){
            if(contains(set, s)){
                count++;
            }
        }

        return count;
    }
}
