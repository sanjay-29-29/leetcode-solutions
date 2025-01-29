class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                res.append('1');
                continue;
            }
            res.append('0');
        }

        return Integer.parseInt(res.toString(), 2);
    }
}
