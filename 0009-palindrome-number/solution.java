class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int temp = x;
        int number = 0;

        while(x>0){
            number = number * 10  + x % 10;
            x /= 10;  
        }


        if(number == temp){
            return true;
        }
        return false;    
    }
}
