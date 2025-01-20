class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0; 
        Set<Character> set = new HashSet<>();
        int max = 0;
        while(left < s.length() && right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }
}
