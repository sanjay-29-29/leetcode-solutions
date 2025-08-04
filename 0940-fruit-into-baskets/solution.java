class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, left = 0, right = 0;

        while (left < fruits.length && right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
        
            while (map.size() > 2) {
                int val = map.get(fruits[left]);
                if (val == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], val - 1);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
