class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(last, -1);

        for(int i = 0; i < s.length(); i++)  {
            int j = s.charAt(i) - 'a';
            first[j] = Math.min(first[j], i);
            last[j] = Math.max(last[j], i);
        }

        // for(int i = 0; i < 26; i++) {
        //     System.out.println(first[i] + " " + last[i]);
        // }

        for(int i = 0; i < 26; i++) {
            if(first[i] == last[i]) continue;
            if(first[i] == Integer.MAX_VALUE || last[i] == -1) continue;

            Set<Character> set = new HashSet<>();

            for(int j = first[i] + 1; j < last[i]; j++) {
                set.add(s.charAt(j));
            }   

            res += set.size();
        }
        

        return res;
    }
}
