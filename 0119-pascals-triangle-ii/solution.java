class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(l);

        for(int i = 1; i <= rowIndex; i++){
            l = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                l.add(getRow(i - 1, j, list) + getRow(i - 1, j - 1, list));
            }
            list.add(l);
        }

        return list.get(rowIndex);
    }


    public int getRow(int i, int j, List<List<Integer>> list){
        int maxCol = list.get(i).size();
        boolean a = (0 <= j && j < maxCol);
        if(!a){
            return 0;
        }
        return list.get(i).get(j);
    }
}
