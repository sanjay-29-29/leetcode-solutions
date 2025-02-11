class Solution {
    public String gcdOfStrings(String str1, String str2) { 
        boolean canMake = false;
        String validPrefix = "";
        String prefix = "";
        int i = 0;

        while(i < str1.length() && i < str2.length()){
            if(str1.charAt(i) == str2.charAt(i)){
                prefix += str1.charAt(i);
                if(canMakeString(prefix, str1) && canMakeString(prefix, str2)){
                    validPrefix = prefix;
                    canMake = true;
                }
            }else{
                return "";
            }
            i++;
        }

        if(canMake){
            return validPrefix;
        }

        return "";
    }

    private boolean canMakeString(String prefix, String str){
        String temp = "";
        while(temp.length() <= str.length()){
            if(str.equals(temp)){
                return true;
            }
            temp += prefix;
        }
        return false;
    }
}
