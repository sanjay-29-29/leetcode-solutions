class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] digitMap = new int[10];
        List<Integer> list = new ArrayList<>();

        for(int i : digits) {
            digitMap[i]++;
        }

        outer : for(int k = 100; k <= 999; k +=2) {
            String a = String.valueOf(k);
            int[] nMap = new int[10];
            for(int i = 0; i < a.length(); i++) {
                nMap[a.charAt(i) - '0']++;
            }
            boolean flag = false;
            for(int i = 0; i < 10; i++){
                if(nMap[i] == 0 && digitMap[i] == 0) {
                    continue;
                }
                if(nMap[i] >= 1 && digitMap[i] < nMap[i]) {
                    continue outer;     
                } else {
                    flag = true;
                }
            }
            if(flag)
            list.add(k);
        }
        int[] res = new int[list.size()];
        int i = 0;
        while(i < res.length) {
            res[i] = list.get(i++);
        }
        return res;
    }
}
