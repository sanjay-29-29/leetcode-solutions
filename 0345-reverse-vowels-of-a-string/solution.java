class Solution {
    public String reverseVowels(String str) {
        StringBuilder s = new StringBuilder(str);
        Set<Character> set = new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            if(!set.contains(s.charAt(left))){
                left++;
            }else if(!set.contains(s.charAt(right))){
                right --;
            }else{
                char temp = s.charAt(left);
                s.setCharAt(left, s.charAt(right));
                s.setCharAt(right, temp);
                left++;
                right--;
            }
        }

        return s.toString();
    }
}
