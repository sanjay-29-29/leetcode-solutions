char findTheDifference(char* s, char* t) {
    int sum1 = 0;
    for(int i=0;s[i]!='\0';i++){
        sum1+=s[i];
    }
    int sum2=0;
    for(int i=0;t[i]!='\0';i++){
        sum2+=t[i];
    }
    return sum2-sum1;
}
