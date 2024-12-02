class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] list = sentence.split(" ");
        
        for(int i = 0; i < list.length; i++){
            boolean flag = false;
            if(list[i].length() < searchWord.length()){
                continue;
            }
            for(int j = 0; j < searchWord.length(); j++){
                if(searchWord.charAt(j) != list[i].charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                return i + 1;
            }
        }

        return -1;
    }
}
