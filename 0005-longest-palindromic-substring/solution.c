char* longestPalindrome(char* s) {
    int max = 0;
    char *res = (char*) malloc(sizeof(char) * 10000);
    int length = strlen(s);

    for (int i = 0; s[i] != '\0'; i++) {
        int left = 0;
        int right = 0;

        while ((i - left) >= 0 && (right + i) < length &&
               (s[i - left] == s[right + i])) {
            int currMax = right + left + 1;
            if (max < currMax) {
                int index = 0;
                for(int j = i - left; j < right + i + 1; j++){
                    res[index++] = s[j];
                }
                res[index] = '\0';
                max = currMax;
            }
            left++;
            right++;
        }

        left = 0;
        right = 1;

        while ((i - left) >= 0 && (right + i) < length &&
               s[i - left] == s[right + i]) {
            int currMax = left + right + 1;
            if (max < currMax) {
                int index = 0;
                for(int j = i - left; j < right + i + 1; j++){
                    res[index++] = s[j];
                }
                res[index] = '\0';
                max = currMax;
            }

            left++;
            right++;
        }
    }

    return res;
}
