class Solution {
    public String interpret(String command) {
        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < command.length()) {
            if (i < command.length() - 3 && command.substring(i, i + 4).equals("(al)")) {
                res.append("al");
                i += 4;
            } else if (i < command.length() - 1 && command.substring(i, i + 2).equals("()")) {
                res.append("o");
                i += 2;
            } else if (command.charAt(i) == 'G') {
                res.append("G");
                i++;
            }
        }

        return res.toString();
    }
}
