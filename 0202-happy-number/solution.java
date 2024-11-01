class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        }
        int no = 0;
        while(n > 0){
            int temp = n % 10;
            no += temp * temp;
            n = n / 10;
        }
        if(set.contains(no)){
            return false;
        }
        set.add(no);
        return isHappy(no);
    }
}
