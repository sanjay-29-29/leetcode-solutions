class Solution {
    public long mostPoints(int[][] questions) {
       return most(questions, 0, new HashMap<>());
    }

    private long most(int[][] questions, int index, Map<Integer, Long> map) {
        if (index >= questions.length) {
            return 0;
        }

        if(map.containsKey(index)){
            return map.get(index);
        }

        long takeCurr = questions[index][0] + most(questions, index + questions[index][1] + 1, map);
        long skip = most(questions, index + 1, map);

        long res = Math.max(takeCurr, skip);
        map.put(index, res);
        return res;
    }
}
