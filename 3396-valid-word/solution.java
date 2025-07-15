class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean vovel = false, consonant = false;
        for (char c : word.toCharArray()) {
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')))
                return false;
            if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'u'
                    || c == 'U')
                vovel = true;
            else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
                consonant = true;
        }
        return vovel && consonant;
    }
}
