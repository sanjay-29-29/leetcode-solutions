class Solution {
    public boolean checkPowersOfThree(int n) {
        String res = "";
        while(n > 0){
            res = (n % 3) + res;
            n = n / 3;
        }

        for(int i = 0; i < res.length(); i++){
            if(res.charAt(i) == '2'){
                return false;
            }
        }

        return true;
    }
}
