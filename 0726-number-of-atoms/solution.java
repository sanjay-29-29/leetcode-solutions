class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = recursion(formula);
        ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());
        
        Collections.sort(sortedKeys);

        String retStr = "";
        
        for (String str : sortedKeys) {
            int key = map.get(str);
            if (key == 1) {
                retStr += str;
            } else {
                retStr += str + key;
            }
        }

        return retStr;
    }

    private Map<String, Integer> recursion(String formula) {
        Map<String, Integer> map = new HashMap<>();

        int i = 0;

        while (i < formula.length()) {
            String atom = "";
            // System.out.print(formula.charAt(i));
            if (formula.charAt(i) == '(') {
                String innerBracket = "";

                int j = i + 1;
                int inCount = 1;
                int outCount = 0;

                while (true) {
                    if (formula.charAt(j) == '(')
                        inCount++;
                    if (formula.charAt(j) == ')')
                        outCount++;
                    if (inCount == outCount)
                        break;
                    innerBracket += formula.charAt(j++);
                }

                j++;

                int n = 0;

                while (j < formula.length()) {
                    if (!(formula.charAt(j) >= 48 && formula.charAt(j) <= 57))
                        break;
                    n = n * 10 + (formula.charAt(j++) - '0');
                }

                if (n == 0)
                    n = 1;

                Map<String, Integer> recMap = recursion(innerBracket);

                for (String str : recMap.keySet()) {
                    if (map.containsKey(str)) {
                        map.put(str, map.get(str) + (n * recMap.get(str)));
                    } else {
                        map.put(str, n * recMap.get(str));
                    }
                }

                i = j - 1;
            }

            else if (formula.charAt(i) >= 65 && formula.charAt(i) <= 90) {
                String ele = "" + formula.charAt(i);

                int j = i + 1;
                int noOfEle = 0;

                boolean flag = false;

                while (j < formula.length()) {
                    if (formula.charAt(j) >= 48 && formula.charAt(j) <= 57) {
                        flag = true;
                    }
                    if ((formula.charAt(j) >= 65 && formula.charAt(j) <= 90) || formula.charAt(j) == '(')
                        break;

                    if (!flag) {
                        ele += formula.charAt(j);
                    } else {
                        noOfEle = noOfEle * 10 + (formula.charAt(j) - '0');
                    }
                    j++;
                }

                if (noOfEle == 0)
                    noOfEle = 1;

                if (map.containsKey(ele)) {
                    map.put(ele, map.get(ele) + noOfEle);
                } else {
                    map.put(ele, noOfEle);
                }

                //System.out.println(ele + " " + noOfEle);
                i = j - 1;
            }

            i++;
        }

        return map;
    }
}
