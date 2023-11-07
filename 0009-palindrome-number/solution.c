bool isPalindrome(int x) {
    if(x<0){
        return false;
    }
    long long temp2 = x;
    long long temp = 0;
    while(x>0){
        temp = temp*10 +(x % 10);
        x = x/10;
    }
    if(temp == temp2){
        return true;
    }
    else{
        return false;
    }
}
