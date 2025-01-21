class Solution {
    private String stringAddOne(String s){
        int carry = 1;
        StringBuilder res = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '1' && carry == 1){
                res.append('0');
            }
            else if(s.charAt(i) == '0' && carry == 1){
                res.append('1');
                carry = 0;
            }else{
                res.append(s.charAt(i));
            }
        }
        if(carry == 1){
            res.append('1');
        }

        return res.reverse().toString();
    }

    private String divideByTwo(String s){
        return "0" + s.substring(0, s.length() - 1); 
    }

    private boolean checkOne(String s){
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '1'){
                return false;
            }
        }
        if(s.charAt(s.length() - 1) == '1'){
            return true;
        }
        return false;
    }

    public int numSteps(String s) {
        if(checkOne(s)){
            return 0;
        }

        if(s.charAt(s.length() - 1) == '0'){
            s = divideByTwo(s);
            return 1 + numSteps(s);
        }
        return  1 + numSteps(stringAddOne(s));
    }
}
