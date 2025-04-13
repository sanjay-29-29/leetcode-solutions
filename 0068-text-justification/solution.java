class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> sentence = new ArrayList<>();
        int currCount = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() + currCount > maxWidth) {
                if (sentence.size() == 1) {
                    res.add(leftJustify(sentence, maxWidth));
                } else {
                    res.add(centerJustify(sentence, maxWidth));
                }
                currCount = words[i].length() + 1;
                sentence.removeAll(sentence);
                sentence.add(words[i]);
            } else {
                sentence.add(words[i]);
                currCount += words[i].length() + 1;
            }
        }

        if (sentence.size() >= 1) {
            res.add(leftJustify(sentence, maxWidth));
        }

        return res;
    }

    private String centerJustify(List<String> list, int maxWidth) {
        int totalLength = 0;
        int totalWords = -1;

        for (String s : list) {
            totalLength += s.length();
            totalWords += 1;
        }

        int space = maxWidth - totalLength;
        int k = 0;  

        StringBuilder res = new StringBuilder();
        List<Integer> spaces = new ArrayList<>();

        for(int i = 0; i < totalWords; i++) {
            spaces.add(0);
        }

        while(space > 0) {
            k = k % totalWords;
            spaces.set(k, spaces.get(k) + 1);
            k++;
            space--;
        }

        for(int i = 0; i < list.size() - 1; i++) {
            res.append(list.get(i));
            for(int j = 0; j < spaces.get(i); j++) {
                res.append(" ");
            }
        }
        
        res.append(list.get(list.size() - 1));
        return res.toString();
    }

    private String leftJustify(List<String> list, int maxWidth) {
        StringBuilder res = new StringBuilder();

        if (list.size() == 1) {
            res.append(list.get(0));
            while (res.length() != maxWidth) {
                res.append(" ");
            }
            return res.toString();
        }

        for (int i = 0; i < list.size() - 1; i++) {
            res.append(list.get(i));
            res.append(" ");
        }
        res.append(list.get(list.size() - 1));

        while (res.length() != maxWidth) {
            res.append(" ");
        }

        return res.toString();
    }
}
