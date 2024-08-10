void reverseString(char* s, int sSize) {
    char temp;
    int length = sSize - 1;

    for(int i=0;i<sSize/2;i++){
        temp = s[i];
        s[i] = s[sSize - i - 1];
        s[sSize - i - 1] = temp;
    }
}
