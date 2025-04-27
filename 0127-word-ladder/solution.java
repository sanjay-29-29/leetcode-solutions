class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.add(beginWord);
        int distance = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String curr = q.poll();

                if(curr.equals(endWord)) {
                    return distance;
                }

                if(set.contains(curr)) {
                    size--;
                    continue;
                }
                set.add(curr);
                
                outer: for (String s : wordList) {
                    int count = 0;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != curr.charAt(i)) {
                            count++;
                        }
                        if (count == 2) {
                            continue outer;
                        }
                    }
                    q.add(s);
                }

                size--;
            }

            distance++;
        }

        return 0;
    }
}
