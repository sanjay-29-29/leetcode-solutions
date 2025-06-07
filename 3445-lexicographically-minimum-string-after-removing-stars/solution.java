class Solution {
    class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public String clearStars(String s) {
        Queue<Pair<Character, Integer>> heap = new PriorityQueue<>((a, b) -> {
            if (a.key.equals(b.key)) {
                return Integer.compare(b.value, a.value);
            }
            return Character.compare(a.key, b.key);
        });

        Set<Integer> set = new HashSet<>();
        StringBuilder res = new StringBuilder();

        int offset = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                Pair<Character, Integer> p = heap.poll();
                set.add(p.value);
            } else {
                heap.offer(new Pair(s.charAt(i), i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i) && s.charAt(i) != '*') {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
