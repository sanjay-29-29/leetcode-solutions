class Solution {
    public int partitionString(String s) {
        int[] arr = new int[26];
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(arr[c - 'a'] == 1){
                //System.out.println(c + " " + i);
                count++;
                arr = new int[26];
                arr[c - 'a'] = 1;
            }else{
                arr[c - 'a'] = 1;
            }
        }

        return count + 1;
    }
}
