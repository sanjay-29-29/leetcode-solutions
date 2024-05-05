char* reversePrefix(char* word, char ch) {

    int pointer = 0;

    for(int i=0;i<strlen(word);i++){
        if(ch == word[i]){
            break;
        }
        pointer ++ ;
    }

    if(pointer == strlen(word)){
        return word;
    }

    int right = pointer;
    int left = 0; 
    char temp;
    while(left<right){
        temp = word[left];
        word[left] = word[right];
        word[right] = temp;
        right--;
        left++;
    }
    return word;
    
    
}
