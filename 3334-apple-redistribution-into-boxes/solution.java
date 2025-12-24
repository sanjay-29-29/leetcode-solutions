class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int[] capCopy = Arrays.copyOf(capacity, capacity.length);
        // Arrays.sort(apple);

        int res = 0, i = apple.length - 1, j = capacity.length - 1;

        while(true) {
            if(i <= -1) {
                break;
            }
            else if(apple[i] <= capacity[j]) {
                capacity[j] -= apple[i];
                i--;
                if(capacity[j] == 0) {
                    j--;
                }
            }
            else {
                apple[i] -= capacity[j];
                capacity[j] = 0;
                j--;
            }
        }

        for(int k = 0; k < capacity.length; k++) {
            if(capCopy[k] != capacity[k]) res++;
        }

        return res;
    }
}
