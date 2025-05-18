class Solution {
    class Helper {
        int i, j;

        Helper(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        String[] str = new String[score.length];
        Queue<Helper> q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.i, a.i);
        });

        for (int i = 0; i < score.length; i++) {
            q.add(new Helper(score[i], i));
        }

        int j = 1;
        for (int i = 0; i < score.length; i++) {
            Helper h = q.poll();
            if(j == 1) {
                str[h.j] = "Gold Medal";
                j++;
            }
            else if(j == 2) {
                str[h.j] = "Silver Medal";
                j++; 
            }
            else if(j == 3) {
                str[h.j] = "Bronze Medal";
                j++;
            }
            else {
                str[h.j] = String.valueOf(j++);
            }
            
        }

        return str;
    }
}
