class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for(int i = digits.length - 1; i >=0; i--){
            if(carry + digits[i] == 10){
                digits[i] = 0;
            }else{
                digits[i] += carry;
                carry = 0;
            }
        }

        if(carry == 0)
            return digits;

        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;
        return newArr;
    }
}
