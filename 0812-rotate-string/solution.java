class Solution {
    HashSet<String> set = new HashSet<>();

    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)){
            return true;
        }
        String newS = s.substring(1,s.length()) + s.substring(0,1);
        if(set.contains(newS)){
            return false;
        }
        set.add(newS);
        return rotateString(newS, goal);
    }
}
