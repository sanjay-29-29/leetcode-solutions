int scoreOfString(char* s) {
    int slow = 0, score = 0, sum = 0;
    for(int fast=1;fast<strlen(s);fast++){
        score = s[slow] - s[fast];
        slow++;
        if(score < 0){
            score = -score;
        }
        sum += score;
    }
    return sum;
}
