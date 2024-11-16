class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length - k + 1; i++) {
            Set<Integer> set = new HashSet<Integer>();
            int power = -1;
            int prevEle = -1;

            for (int j = 0; j < k; j++) {
                int currEle = nums[i + j];

                if (j == 0) {
                    power = Math.max(power, currEle);
                    prevEle = currEle;
                    set.add(currEle);
                    continue;
                }

                if (currEle < prevEle || !set.contains(currEle - 1) || set.contains(currEle)) {
                    power = -1;
                    break;
                }

                set.add(currEle);
                prevEle = currEle;
                power = Math.max(power, currEle);
            }
            list.add(power);
        }

        int[] returnList = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            returnList[i] = list.get(i);
        return returnList;
    }
}
