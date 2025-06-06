class Solution {
    public String convertDateToBinary(String date) {
        String[] split = date.split("-");
        String res = Integer.toBinaryString(Integer.valueOf(split[0]))
                + "-" + Integer.toBinaryString(Integer.valueOf(split[1])) + "-"
                + Integer.toBinaryString(Integer.valueOf(split[2]));
        return res;
    }
}
