class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        
        for (int i : map.keySet()) {
            int val = map.get(i);
            if (i == 0) {
                count += val;
            } else {
                if (val < (i + 1)) {
                    count += i + 1;
                } else if (val % (i + 1) == 0) {
                    count += (i + 1) * (val / (i + 1));
                } else {
                    count += (i + 1) * (val / (i + 1));
                    count += (i + 1);
                }
            }
        }

        return count;
    }
}
