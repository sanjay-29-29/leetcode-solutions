class Solution {
    public String convertToBase7(int num) {
        if(num == 0){
           return "0";
        }

        boolean isNegative = (num < 0);
        num = Math.abs(num);
        String res = "";

        while(num > 0){
            //res.append(num % 7);
            res = (num % 7) + res;
            num /= 7; 
        }

        if(isNegative){
            return "-" + res.toString();
        }
        return res.toString();
    }
}
