class Solution {
    public int minFlips(int a, int b, int c) {
        String x = Integer.toBinaryString(a);
        String y = Integer.toBinaryString(b);
        String z = Integer.toBinaryString(c);

        String zeroRep = "00000000000000000000000000000000";

        x = zeroRep.substring(0, 32 - x.length()) + x;
        y = zeroRep.substring(0, 32 - y.length()) + y;
        z = zeroRep.substring(0, 32 - z.length()) + z;

        int count = 0;
        for(int i = 0; i < 32; i++){
            if(z.charAt(i) == '1'){
                if(y.charAt(i) == '0' && x.charAt(i) == '0'){
                    count++;
                }
            }
            if(z.charAt(i) == '0'){
                if(y.charAt(i) == '1' && x.charAt(i) == '1'){
                    count += 2;
                }
                else if(y.charAt(i) == '1' || x.charAt(i) == '1'){
                    count += 1;
                }
            }
        }

        return count;
    }
}
