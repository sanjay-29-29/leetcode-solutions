class Solution {
    public int maxDiff(int num) {
        StringBuilder a = new StringBuilder(String.valueOf(num));
        
        boolean[] visited = new boolean[10];
        Set<Integer> set = new HashSet<>();

        int min = num, max = num;

        for(int i = 0; i < a.length(); i++) {
            char digit = a.charAt(i);

            if(visited[digit - '0']) {
                continue;
            }
            visited[digit - '0'] = true;

            for(int j = 0; j <= 9; j++) {
                StringBuilder temp = new StringBuilder(a);
                for(int k = 0; k < temp.length(); k++) {
                    if(temp.charAt(k) == digit) {
                        temp.setCharAt(k, (char) (j + '0'));
                    }
                }
                if(isValid(temp)) {
                    int t = Integer.valueOf(temp.toString());
                    max = Math.max(max, t);
                    min = Math.min(min, t);
                }
            }
        }

        return max - min;
    }

    private boolean isValid(StringBuilder s) {
        // System.out.println(s);
        if(Integer.valueOf(s.toString()) == 0) {
            return false;
        }
        boolean zeroMet = false;
        for(int i = 0; i < s.length(); i++) {
            char digit = s.charAt(i);
            if(digit == '0') {
                zeroMet = true;
            }
            if(digit >= '1' && digit <= '9') {
                if(zeroMet) {
                    return false;
                }
                return true;
            }
        }

        return true;
    }
}
