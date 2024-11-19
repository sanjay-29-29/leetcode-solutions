// class Solution {
//     public String decodeString(String s) {
//         int i = 0;
//         int n = 0;
//         while (i < s.length()) {
//             char c = s.charAt(i);

//             if (c == '[') {
//                 int count = 1;
//                 int j = 0;
//                 String characters = "";

//                 while (count > 0) {
//                     j++;
//                     if (s.charAt(i + j) == '[')
//                         count++;
//                     if (s.charAt(i + j) == ']')
//                         if (count - 1 == 0) {
//                             break;
//                         } else {
//                             count--;
//                         }
//                     characters += s.charAt(i + j);
//                 }
//                 System.out.println(characters);
//                 for(int i = 0; i < n; i++){

//                 }
//                 i = i + j;
//             } else {
//                 n += (c - '0') * 10;
//                 System.out.println(n);
//             }
//             i++;
//         }

//         return s;
//     }
// }
class Solution {
    public String decodeString(String s) {
        return recursion(s);
    }

    private String recursion(String s) {
        int n = 0;
        String newStr = "";
        int i = 0;

        while(i < s.length()) {
            char c = s.charAt(i);
            if (s.charAt(i) == '[') {
                int j = 0;
                int count = 1;
                String characters = "";

                while (count > 0) {
                    j++;
                    if (s.charAt(i + j) == '[')
                        count++;
                    if (s.charAt(i + j) == ']')
                        if (count - 1 == 0) {
                            break;
                        } else {
                            count--;
                        }
                    characters += s.charAt(i + j);
                }

                String recursionRes = recursion(characters);
                
                for (int k = 0; k < n; k++) {
                    newStr +=  recursionRes;
                }

                n = 0;
                i = i + j;
            }
            else if( !(c >= '0') || !(c <= '9')){
                newStr += c;
                n = 0;
            }else{
                n = n * 10 + (c - '0');
            }
            i++;
        }

        return newStr;
    }
}
