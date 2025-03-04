class Solution {
    String s1, s2, s3;
    Map<String, Boolean> map = new HashMap<>();
    
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return recursion(0, 0, 0);
    }

    private boolean recursion(int i1, int i2, int i3){
        if(i1 >= s1.length() && i2 >= s2.length() && i3 >= s3.length()){
            return true;
        }

        if(i1 >= s1.length()){
            while(i2 < s2.length() && i3 < s3.length()){
                if(s2.charAt(i2) != s3.charAt(i3)){
                    return false;
                }
                i2++;
                i3++;
            }
            if(i2 >= s2.length() && i3 >= s3.length())
                return true;
            return false;
        }

        if(i2 >= s2.length()){
            while(i1 < s1.length() && i3 < s3.length()){
                if(s1.charAt(i1) != s3.charAt(i3)){
                    return false;
                }
                i1++;
                i3++;
            }
            if(i1 >= s1.length() && i3 >= s3.length())
                return true;
            return false;
        }

        if(i3 >= s3.length()){
            return false;
        }

        String key = i1 + " " + i2;

        if(map.containsKey(key)){
            return map.get(key);
        }

        if(s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3)){
            boolean val = recursion(i1 + 1, i2, i3 + 1) || recursion(i1, i2 + 1, i3 + 1);
            map.put(key, val);
            return val;
        }

        if(s1.charAt(i1) == s3.charAt(i3)){
            boolean val = recursion(i1 + 1, i2, i3 + 1);
            map.put(key, val);
            return val;
        }

        if(s2.charAt(i2) == s3.charAt(i3)){
            boolean val = recursion(i1, i2 + 1, i3 + 1);
            map.put(key, val);
            return val;
        }

        return false;
    }
}
