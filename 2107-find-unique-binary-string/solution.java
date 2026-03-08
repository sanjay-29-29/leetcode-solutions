class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxInt = (int) Math.pow(2, nums[0].length());

        for(String s : nums) {
            set.add(Integer.parseInt(s, 2));
        }

        for(int i = 0; i < maxInt; i++) {
            if(!set.contains(i)) {
                StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
                while(s.length() != nums[0].length()) {
                    s.insert(0, '0');
                }
                return s.toString();
            }
        }

        return "";
    }
}
