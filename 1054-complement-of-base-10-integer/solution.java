class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }

        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                s.setCharAt(i, '1');
            }else{
                s.setCharAt(i, '0');
            }
        }
        // System.out.println(s);
        return Integer.parseInt(s.toString(), 2);
    }
}
