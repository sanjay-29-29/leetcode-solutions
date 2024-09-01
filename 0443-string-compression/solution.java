class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        
        int slow = 0;
        int fast = 0;
        String str = "";
        
        while(slow<chars.length){
            str += chars[slow];
            int count = 0;
            while(fast<chars.length && chars[slow] == chars[fast]){
                count ++;
                fast++;
            }
            slow = fast;
            if(count>1){
                str += count;
            }
        }
        for(int i=0;i<str.length();i++){
            chars[i] = Character.valueOf(str.charAt(i));
            System.out.println(chars[i]);
        }
        System.out.println(str);
        return str.length();
    }
}
