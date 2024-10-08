class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        int number = 0;

        int i = 0;
        int n = s.length();

        while(n>i){
            if(s.charAt(i) == 'I' && i+1<n){
                if(s.charAt(i+1) == 'V'){
                    number += 4;
                    i+=2;
                    continue;
                }
                if(s.charAt(i+1) == 'X'){
                    number += 9;
                    i+=2;
                    continue;
                }
            }
            if(s.charAt(i) == 'X' && i+1<n){
                if(s.charAt(i+1) == 'L'){
                    number += 40;
                    i+=2;
                    continue;
                }
                if(s.charAt(i+1)=='C'){
                    number += 90;
                    i+=2;
                    continue;
                }
            }
            if(s.charAt(i) == 'C' && i+1<n){
                if(s.charAt(i+1) == 'D'){
                    number += 400;
                    i+=2;
                    continue;
                }
                if(s.charAt(i+1)=='M'){
                    number += 900;
                    i+=2;
                    continue;
                }
            }
            if(map.containsKey(Character.toString(s.charAt(i)))){
                number += map.get(Character.toString(s.charAt(i)));
            }
            i++;
        }
        return number;
    }
}
