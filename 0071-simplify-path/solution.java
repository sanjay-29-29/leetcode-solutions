class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0;

        while (i < path.length()) {
            char s = path.charAt(i);
            
            if (s == '.') {
                int j = 0;
                boolean flag = false;

                while ((i + j) < path.length()) {
                    if(path.charAt(i + j) == '.'){
                        j++;
                    }
                    else if(path.charAt(i + j) == '/'){
                        break;
                    }
                    else{
                        flag = true;
                        j++;
                    }
                    
                }
                if (stack.size() >= 1 && j == 2 && !flag) {
                    stack.pop();
                   // stack.pop();
                }
                else if (j > 2 || flag) {
                    stack.add(path.substring(i, i + j));
                }
                i = i + j;
            }

            else if (s == '/') {
                int j = 1;
                while ((i + j) < path.length() && path.charAt(i + j) == '/') {
                    j++;
                }
                //stack.push("/");
                i = i + j;
            }

            else {
                int j = 0;
                String fileName = "";
                while ((i + j) < path.length()) {
                    if(path.charAt(i + j) == '.'){
                        j++;
                    }
                    else if(path.charAt(i + j) == '/'){
                        break;
                    }
                    else{
                        j++;
                    }
                    
                }
                stack.push(path.substring(i, i + j));
                i = i + j;
            }
        }

        List<String> list = new ArrayList<>(stack);
        String str = "/";
        boolean flag = false;
        for(String s : list){
            flag = true;
            str += s;
            str += "/";
        }
        if(flag)
            return str.substring(0,str.length() - 1);
        return str;
    }
}
