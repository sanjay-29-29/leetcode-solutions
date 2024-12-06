class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;
        StringBuilder str = new StringBuilder();

        while(i < s.length()){
            char c = s.charAt(i);
            if(c == ' '){
                if(!str.toString().equals("")){
                    list.add(str.toString());
                    str.delete(0, str.length());
                }
            }else{
                str.append(c);
            }
            i++;
        }

        if(!str.toString().trim().equals(""))
        list.add(str.toString()); 
        
        String retString = "";

        for(i = list.size() - 1; i>= 0; i--){
            retString += list.get(i);
            if(i != 0)
                retString += " ";
        }

        return retString;
    }
}
