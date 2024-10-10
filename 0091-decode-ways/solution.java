class Solution {
    HashMap<String,Integer> map;
    public int numDecodings(String s) {
        map = new HashMap<>();
        return recursion(s);
    }

    public int recursion(String s){
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s.length() == 0){
            return 1;
        }
        if(s.charAt(0) == '0'){
            return 0;
        }
        
        int val;

        if(s.length() >= 2 ){
            int num = Integer.parseInt(s.substring(0,2));
            if(num>=10 && num<=26){
                val = recursion(s.substring(2,s.length())) + recursion(s.substring(1,s.length()));
            map.put(s,val);
            return val;
            }
        }
        val = recursion(s.substring(1,s.length()));
        map.put(s,val);
        return val;
    }
}
