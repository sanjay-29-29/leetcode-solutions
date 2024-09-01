class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int length;
        String word = "";
        if(str1.length()>str2.length()){
            length = gcd(str1.length(),str2.length());
        }else{
            length = gcd(str2.length(),str1.length());
        }
        for(int i=0;i<length;i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                return "";
            }else{
                word = word + str1.charAt(i);
            }
        }

        for(int i=0;i<str1.length();i+=word.length()){
            for(int j=0;j<word.length();j++){
                if(str1.charAt(i+j) != word.charAt(j)){
                    return "";
                }
            }
        }
        for(int i=0;i<str2.length();i+=word.length()){
            for(int j=0;j<word.length();j++){
                if(str2.charAt(i+j) != word.charAt(j)){
                    return "";
                }
            }
        }
        return word;
    }

    int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }
}
