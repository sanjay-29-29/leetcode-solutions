class Solution {
    public String intToRoman(int n) {
        String ret = "";

        while(n > 0){
            if(n >= 1000){
                ret += "M";
                n -= 1000;
            }
            else if(n >= 900){
                ret += "CM";
                n -= 900;
            }
            else if(n >= 500){
                ret += "D";
                n -= 500;
            }
            else if(n >= 400){
                ret += "CD";
                n -= 400;
            } 
            else if(n >= 100){
                ret += "C";
                n -= 100;
            }
            else if(n >= 90){
                ret += "XC";
                n -= 90;
            }
            else if(n >= 50){
                ret += "L";
                n -= 50;
            }
            else if(n >= 40){
                ret += "XL";
                n -= 40;
            }
            else if(n >= 10){
                ret += "X";
                n -= 10;
            }
            else if(n >= 9){
                ret += "IX";
                n -= 9;
            }
            else if(n >= 5){
                ret += "V";
                n -= 5;
            }
            else if(n >= 4){
                ret += "IV";
                n -= 9;
            }
            else if(n >= 1){
                ret += "I";
                n -= 1;
            }
        }

        return ret;
    }
}
