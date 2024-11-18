class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] returnArr = new int[code.length];

        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    int currIndex = (j + i + 1) % code.length;
                    sum += code[currIndex];
                }
                returnArr[i] = sum;
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                int sum = 0;
                for (int j = 0; j < -k; j++) {
                    int currIndex = (i - j  - 1) % code.length;
                    if(currIndex < 0){
                        currIndex = currIndex + code.length;
                    }
                    System.out.print(currIndex + " ");
                    sum += code[currIndex];
                }
                System.out.println();
                returnArr[i] = sum;
            }
        }

        return returnArr;
    }
}
