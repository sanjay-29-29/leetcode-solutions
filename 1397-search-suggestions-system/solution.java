class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();

        for(String s : products){
            trie.insertWord(s);
        }

        for(int i = 1; i < searchWord.length() + 1; i++){
            List<String> suggestions = trie.suggestWord(searchWord.substring(0,i));
            // System.out.println(searchWord.substring(0,i));
            res.add(suggestions);
        }

        return res;
    }
}

class TrieNode{
    boolean isWordEnd;
    TrieNode[] word = new TrieNode[26];
}

class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void insertWord(String s){
        TrieNode curr = root;

        for(int i = 0; i < s.length(); i++){
            if(curr.word[s.charAt(i) - 'a'] == null)
                curr.word[s.charAt(i) - 'a'] = new TrieNode();
            curr = curr.word[s.charAt(i) - 'a'];
        }

        curr.isWordEnd = true;
    }

    public List<String> suggestWord(String s){
        TrieNode curr = root;
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(curr.word[s.charAt(i)- 'a'] == null){
                return res;
            }
            curr = curr.word[s.charAt(i)- 'a'];
        }
        traverse(curr, s, res);
        return res;
    }

    private void traverse(TrieNode root, String word, List<String> res){
        if(root == null){
            return;
        }

        if(root.isWordEnd){
            if(res.size() == 3){
                return;
            }
            res.add(word);
            //return;
        }

        for(int i = 0; i < 26; i++){
            traverse(root.word[i], word + (char)('a' + i), res);
        }
    }
}
