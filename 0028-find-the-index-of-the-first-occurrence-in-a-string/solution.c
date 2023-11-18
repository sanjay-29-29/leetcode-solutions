int strStr(char* haystack, char* needle) {
    int haystackLen = strlen(haystack);
    int needleLen = strlen(needle);

    if (needleLen == 0) {
        return 0; // If needle is an empty string, return 0
    }

    int i, j;
    for (i = 0; i <= haystackLen - needleLen; i++) {
        for (j = 0; j < needleLen; j++) {
            if (haystack[i + j] != needle[j]) {
                break;
            }
        }
        if (j == needleLen) {
            return i; // Found the needle in haystack at index i
        }
    }

    return -1; // Needle not found in haystack
}
