class Solution {
    public String pushDominoes(String dominoes) {
        int[] rightForce = new int[dominoes.length()];
        int[] leftForce = new int[dominoes.length()];
        int currForce = 0;

        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'R') {
                currForce = Integer.MAX_VALUE;
            } else if (c == 'L') {
                currForce = 0;
            } else if (currForce > 0) {
                currForce -= 1;
            }
            rightForce[i] = currForce;
        }

        currForce = 0;

        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                currForce = Integer.MAX_VALUE;
            } else if (c == 'R') {
                currForce = 0;
            } else if (currForce > 0) {
                currForce -= 1;
            }
            leftForce[i] = currForce;
        }

        // for (int i : leftForce) {
        //     System.out.print(i + " ");
        // }

        // System.out.println();
        // for (int i : rightForce) {
        //     System.out.print(i + " ");
        // }

        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < rightForce.length; i++) {
            if (rightForce[i] == leftForce[i]) {
                res.append('.');
            } else if (rightForce[i] > leftForce[i]) {
                res.append('R');
            } else {
                res.append('L');
            }
        }
        return res.toString();
    }
}
