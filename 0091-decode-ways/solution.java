class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        return recursion(s);
    }

    public int recursion(String s){
        if(s.length() == 0){
            return 1;
        }

        if(s.charAt(0) == '0'){
            return 0;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }    

        if(s.length() >= 2){
            int n = ((s.charAt(0) - '0') * 10) + (s.charAt(1) - '0');
            if(n <= 26){
                int val = recursion(s.substring(1, s.length())) + recursion(s.substring(2, s.length()));
                map.put(s, val);
                return val;
            }
        }
        
        int val = recursion(s.substring(1, s.length()));
        map.put(s, val);
        return val;
    }
}
