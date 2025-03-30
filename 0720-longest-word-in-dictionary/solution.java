class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";

        for(int i = 0; i < words.length; i++){
            set.add(words[i]);
            for(int j = 1; j <= words[i].length(); j++){
                if(!set.contains(words[i].substring(0, j))){
                    break;
                }
                if(j == words[i].length()){
                    if(res.length() == words[i].length()){
                        if(res.compareTo(words[i]) > 0){
                            res = words[i];
                        }
                    }
                    else if(res.length() < words[i].length()){
                        res = words[i];
                    }
                }
            }
        }

        return res;
    }
}
