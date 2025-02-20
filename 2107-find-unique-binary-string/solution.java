class Solution {
    private void recursion(String str, int n, List<String> res){
        if(n == 0){
            res.add(str);
            return;
        }

        recursion(str + "0", n - 1, res);
        recursion(str + "1", n - 1, res);
    }

    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();

        for(String s : nums){
            set.add(s);
        }

        List<String> res = new ArrayList<>();
        recursion("", nums[0].length(), res);

        for(String s : res){
            if(!set.contains(s)){
                return s;
            }
        }

        return "";
    }
}
