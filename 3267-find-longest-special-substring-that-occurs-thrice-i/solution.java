class Solution {
    public int maximumLength(String s) {
        int maxCount = 0; 
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String str = "";
                char prev = s.charAt(j);
                boolean flag = false; 
                
                for(int k = i; k < j + 1; k++){
                    char temp = s.charAt(k);
                    if(temp != prev){
                        flag = true;
                        break;
                    }
                    str += temp;
                }
                
                if(flag == true) continue;

                if(!map.containsKey(str)){
                    map.put(str, 1);
                }
                else{
                    int val = map.get(str);
                    val++;
                    if(val >= 3){
                        maxCount = Math.max(str.length(), maxCount);
                    }
                    map.put(str, val);
                }
            }
        }
        if(maxCount == 0) return -1;
        return maxCount;
    }
}
