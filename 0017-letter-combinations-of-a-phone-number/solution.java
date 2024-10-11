class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<String>();
        recursion(list,digits,"");
        return list;
    }
    private void recursion(List<String> list, String digits, String newStr){
        if(digits.length() == 0){
            list.add(newStr);
            return;
        }
        int curr = Integer.parseInt(digits.substring(0,1));
        int sp = 0;
        int index = 3;
        if(curr == 7 || curr == 9){
            index = 4;
        }
        if(curr > 7){
            sp = 1;
        }
        for(int i=0;i<index;i++){
            recursion(list, digits.substring(1,digits.length()),newStr + (char)(97 + ((curr-2)*3)+i+sp));
        }
    }
}
