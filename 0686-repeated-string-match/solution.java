class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        String str = "";

        while(str.length() < (b.length() + a.length())){
            str += a;
            count++;
            if(str.contains(b)){
                return count;
            }
        }

        return -1;

    }
}
