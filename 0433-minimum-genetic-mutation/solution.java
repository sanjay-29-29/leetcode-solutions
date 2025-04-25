class Solution {
    class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Pair<>(startGene, 0));

        while (!queue.isEmpty()) {
            Pair<String, Integer> curr = queue.poll();
            if (visited.contains(curr.key)) {
                continue;
            }
            visited.add(curr.key);
            if (curr.key.equals(endGene)) {
                return curr.value;
            }

            StringBuilder str = new StringBuilder(curr.key);

            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);

                str.setCharAt(i, 'A');
                if (set.contains(str.toString())) {
                    queue.add(new Pair<>(str.toString(), curr.value + 1));
                }

                str.setCharAt(i, 'C');
                if (set.contains(str.toString())) {
                    queue.add(new Pair<>(str.toString(), curr.value + 1));
                }

                str.setCharAt(i, 'G');
                if (set.contains(str.toString())) {
                    queue.add(new Pair<>(str.toString(), curr.value + 1));
                }

                str.setCharAt(i, 'T');
                if (set.contains(str.toString())) {
                    queue.add(new Pair<>(str.toString(), curr.value + 1));
                }

                str.setCharAt(i, temp);
            }
        }

        return -1;
    }
}
