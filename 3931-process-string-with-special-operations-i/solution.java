class Solution {
    public String processStr(String s) {
        List<Character> list = new LinkedList<>();

        for(char c : s.toCharArray()) {
            if(c == '*') {
                if(list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            }
            else if(c == '#') { 
               list.addAll(list);
            }
            else if(c == '%') {
                Collections.reverse(list);
            } 
            else {
                list.add(c);
            }
        }

        StringBuilder res = new StringBuilder("");

        for(char c : list) {
            res.append(c);
        }

        return res.toString();
    }
}
