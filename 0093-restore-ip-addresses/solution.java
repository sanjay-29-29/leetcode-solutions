class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backTrack(new StringBuilder(s), 0, 0, res);
        return res;
    }

    private void backTrack(StringBuilder s, int index, int dotCount, List<String> res){
        if(dotCount == 3){
            //System.out.println(s);
            if(isValid(s.substring(index, s.length()))){
                res.add(s.toString());
            }
            return;
        }

        for(int i = index; i < s.length() && i <= index + 3; i++){
            if(isValid(s.substring(index, i))){
                s.insert(i, '.');
                backTrack(s, i + 1, dotCount + 1, res);
                s.deleteCharAt(i);
            }
        }
    }


    private boolean isValid(String s){
        if(s.length() == 0){
            return false;
        }

        if(s.charAt(0) == '0'){
            if(s.length() == 1) return true;
            return false;
       }

        if(s.length() > 3){
            return false;
        }

        if(s.length() >= 0 && s.length() <= 3 && Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255){
            return true;
        }

        return false;
    }
}
