class Solution {
    List<String> wordDict;
    List<String> resList = new ArrayList<>();
    String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        this.s = s;
        recursion("", "", 0);
        return resList;
    }

    private void recursion(String sentence, String currWord, int index){
        if(index >= s.length()){
            if(wordDict.contains(currWord)){
                sentence += currWord;
                sentence.trim();
                resList.add(sentence);
            }
            return;
        }

        if(wordDict.contains(currWord)){
            String newSentence = sentence + currWord + " ";
            recursion(newSentence, "", index);
        }
        recursion(sentence, currWord + s.charAt(index), index + 1);
    }
}
