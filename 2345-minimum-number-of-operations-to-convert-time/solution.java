class Solution {
    public int convertTime(String current, String correct) {
        int diff = difference(current, correct);
        int count = 0;
        while(diff > 0){
            if(diff >= 60){
                diff -= 60;
            }
            else if(diff >= 15){
                diff -= 15;
            }
            else if(diff >= 5){
                diff -= 5;
            }
            else if(diff >= 1){
                diff -= 1;
            }
            count++;
        }

        return count;
    }

    private int difference(String current, String correct) {
        String[] a1 = current.split(":");
        String[] a2 = correct.split(":");

        int[] b1 = {Integer.valueOf(a1[0]), Integer.valueOf(a1[1])};
        int[] b2 = {Integer.valueOf(a2[0]), Integer.valueOf(a2[1])};

        int diff = 0;

        while(b1[0] != b2[0] || b1[1] != b2[1]){
            diff++;
            b1[1]++;
            if(b1[1] == 60){
                b1[0]++;
                b1[1] = 0;
            }
        }
        return diff;
    }
}
