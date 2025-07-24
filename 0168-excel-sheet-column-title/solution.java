class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        
        while(columnNumber > 0) {
            columnNumber -= 1;
            int curr = columnNumber % 26;
            res.append((char)(curr + 'A'));
            columnNumber = columnNumber / 26;
        }
        res.reverse();
        return res.toString();
    }
}
