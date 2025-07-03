class Solution {
    public char kthCharacter(int k) {
        return recurse("a", k).charAt(k - 1);
    }

    private String recurse(String a, int k) {
        if(k <= a.length()) {
            return a;
        }

        StringBuilder res = new StringBuilder(a);

        for(char c : a.toCharArray()) {
           if(c == 'z') {
                res.append('a');
           } else {
                res.append((char)(c + 1));
           }
        }

        // System.out.println(res);

        return recurse(res.toString(), k);
    }
}
