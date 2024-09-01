class Solution {
    public String reverseWords(String s) {
        List<String> arr = new ArrayList<String>();
        boolean wordStarted = false;
        s = s.trim();
        String str = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                if(wordStarted){
                    arr.add(str);
                    str = "";
                    wordStarted = false;
                }
            }else{
                wordStarted = true;
                str += String.valueOf(s.charAt(i));
            }
        }
        arr.add(str);
        str = "";
        for(int i=arr.size()-1 ;i>=0;i--){
            str = str + arr.get(i);
            if(i!=0){
                str += " ";
            }
        }
        return str;
    }
}
