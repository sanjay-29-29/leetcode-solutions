class Solution {
    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int n = 0;
        backTrack(new StringBuilder(s), 0, 0);
        return list;
    }

    public void backTrack(StringBuilder s, int index, int count) {
        if (count == 3 && index < s.length()) {
            if(checkSegment(s.substring(index, s.length())))
                list.add(s.toString());
            return;
        }

        int n = 0;
        
        for (int i = index; i < s.length(); i++) {
            n = n * 10 + (s.charAt(i) - '0');

            if(s.charAt(index) == '0' && index - i > 0 ){
                return;
            }

            if (checkSegment(s.substring(index, i + 1))) {
                s.insert(i + 1, ".");
                backTrack(s, i + 2, count + 1);
                s.deleteCharAt(i + 1);
            }
        }
    }

    public boolean checkSegment(String s) {
        int n = 0;
        if(s.charAt(0) == '0' && s.length() > 1)
            return false;
        for(int i = 0; i < s.length(); i++){
            n = n * 10 + (s.charAt(i) - '0');
            if(n > 255){
                return false;
            }
        }
        return true;
    }
}
