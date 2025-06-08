class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(n, 0, res);
        return res;
    }

    private void dfs(int n, int curr, List<Integer> res) {
        // if(curr > n) {
        //     return;
        // }

        for(int i = 0; i <= 9; i++) {
            int no = curr * 10 + i;
            if(no > n) {
                continue;
            }
            if(no != 0){
                res.add(no);
                dfs(n, no, res);
            }
        }
    }
}
