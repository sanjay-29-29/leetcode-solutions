class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(l);

        for(int i = 1; i < numRows; i++){
            l = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                int left = getTop(i - 1, j, list);
                int right = getTop(i - 1, j - 1, list);
                l.add(left + right);
            }
            list.add(l);
        }
        return list;
    }

    public int getTop(int i, int j, List<List<Integer>> list){
        //System.out.println(list.size() + " " + i);
        int maxCol = list.get(i).size();
        boolean a = (0 <= j && j < maxCol);
        if(!a){
            return 0;
        }
        return list.get(i).get(j);
    }
}
