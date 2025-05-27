class Solution {
    public int differenceOfSums(int n, int m) {
        int total = 0;
        int not = 0;

        for(int i = 1; i <= n; i++) {
            if(i % m == 0) {
                not += i;
            }else {
                total += i;
            }
        }
        
        return total - not;
    }
}
