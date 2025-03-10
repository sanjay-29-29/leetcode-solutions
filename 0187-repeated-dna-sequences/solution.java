class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>(); 

        for(int i = 0; i < s.length() - 10 + 1; i++){
            String ss = s.substring(i, i + 10);
            if(set.contains(ss)){
                res.add(ss);
            }else{
                set.add(ss);
            }
        }

        return new ArrayList<>(res);
    }
}
