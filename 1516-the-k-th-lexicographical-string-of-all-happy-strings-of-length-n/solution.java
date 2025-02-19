class Solution {
    private void generateAllStrings(int n, int prev, String str, Set<String> res){
        if(n == 0){
            res.add(str);
            return;
        }

        prev = prev % 3;

        if(prev == 0){
            generateAllStrings(n - 1, 1, str + "b", res);
            generateAllStrings(n - 1, 2, str + "c", res);
        }
        if(prev == 1){
            generateAllStrings(n - 1, 0, str + "a", res);
            generateAllStrings(n - 1, 2, str + "c", res);
        }
        if(prev == 2){
            generateAllStrings(n - 1, 1, str + "b", res);
            generateAllStrings(n - 1, 0, str + "a", res);
        }
    }

    public String getHappyString(int n, int k) {
       Set<String> res = new HashSet<>(); 
       generateAllStrings(n, 0, "", res);
       generateAllStrings(n, 1, "", res);
       generateAllStrings(n, 2, "", res);
       List<String> list = new ArrayList<>(res);
       if(list.size() < k){
        return "";
       }
       Collections.sort(list);
       //System.out.println(res);
       return list.get(k - 1);
    }
}
