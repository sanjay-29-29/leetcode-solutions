class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int a = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].contains("+")) {
                a++;
            } else {
                a--;
            }
        }
        return a;
    }
}
