bool isVovel(char s){
    if(s=='a'||s=='e'||s=='i'||s=='o'||s=='u')
        return true;
    return false;
}

int maxVowels(char* s, int k) {
    int n = strlen(s);
    int count = 0;

    if(k>=n){
        for(int i=0;i<n;i++){
            if(isVovel(s[i])){
                count++;
            }
        }
        return count;
    }
    
    for(int i=0;i<k;i++){
        if(isVovel(s[i])){
            count++;
        }
    }
    int max = count;
    for(int i=1;i<n-k+1;i++){
        if(isVovel(s[i-1])){
            count--;
        }
        if(isVovel(s[i+k-1])){
            count++;
        }
        if(count>max){
            max = count;
        }
        if(count == k){
            return count;
        }
    }
    return max;
}
