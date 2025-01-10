class Solution {
    public String decodeString(String s) {
        String res = "";
        int i = 0;
        int bracketCount = 0; 
        int number = 0;

        while(i < s.length()){
            if(s.charAt(i) == '['){
                bracketCount++;         
                String charInBracket = "";
                int j = i + 1;
                while(j < s.length()){
                    if(s.charAt(j) == ']'){
                        bracketCount--;
                        if(bracketCount == 0){
                            break;
                        }
                        charInBracket += s.charAt(j);
                    }
                    else if(s.charAt(j) == '['){
                        charInBracket += s.charAt(j);
                        bracketCount++;
                    }
                    else{
                        charInBracket += s.charAt(j);
                    }
                    j++;
                }
                i = j;
                String decoded = decodeString(charInBracket);
                for(int k = 0; k < number; k++){
                    res += decoded;
                }
                //System.out.println(res);
                number = 0;
            }
            else if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
                number = number * 10;
                number += s.charAt(i) - 48;
            }
            else{
                res += s.charAt(i);
            }
            i++;
        }

        return res;
    }
}
