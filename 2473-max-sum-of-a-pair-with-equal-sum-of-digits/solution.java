class Solution {
    private int calcDigitSum(int num){
        int temp = 0;

        while(num > 0){
            temp += num % 10;
            num /= 10;
        }

        return temp;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = -1; 

        for(int i = 0; i < nums.length; i++){
            int digitSum = calcDigitSum(nums[i]);
            List<Integer> list = map.getOrDefault(digitSum, new ArrayList<>());
            list.add(nums[i]);
            map.put(digitSum, list);
        }

        for(int i : map.keySet()){
            //System.out.println(i);
            List<Integer> list = map.get(i);
            Collections.sort(list, Collections.reverseOrder());
            if(list.size() < 2){
                continue;
            }
            max = Math.max(max, list.get(0) + list.get(1));
        }

        return max;
    }
}
