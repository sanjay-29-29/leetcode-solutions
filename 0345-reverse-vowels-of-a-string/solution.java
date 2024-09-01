class Solution {
    public String reverseVowels(String str) {
        StringBuilder s = new StringBuilder(str);
        int left = 0;
        int right = s.length() -1;
        boolean left_flag = false;
        boolean right_flag = false;

        while(left<=right){
            if(!left_flag && ( 
                Character.toLowerCase(s.charAt(left))!='a' && 
                Character.toLowerCase(s.charAt(left))!='e' && 
                Character.toLowerCase(s.charAt(left))!='i' && 
                Character.toLowerCase(s.charAt(left))!='o' && 
                Character.toLowerCase(s.charAt(left))!='u')){
                System.out.println("left");
                left++;
            }else{
                left_flag = true;
            }

            if(!right_flag && (
                Character.toLowerCase(s.charAt(right))!='a' && 
                Character.toLowerCase(s.charAt(right))!='e' &&
                Character.toLowerCase(s.charAt(right))!='i' && 
                Character.toLowerCase(s.charAt(right))!='o' && 
                Character.toLowerCase(s.charAt(right))!='u')){
                right--;
                System.out.println("right");
            }else{
                right_flag = true;
            }
            if(right_flag && left_flag){
                System.out.println("swap");
                right_flag = false;
                left_flag = false;
                char temp = s.charAt(left);
                s.setCharAt(left,s.charAt(right));
                s.setCharAt(right,temp);
                left++;
                right--;
            }
        }
        return s.toString();
    }
}
