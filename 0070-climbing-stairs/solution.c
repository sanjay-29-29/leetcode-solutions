int climbStairs(int n) {
    int sum = 0;
    int a = 0;
    int b = 1;
    int c = 0;
    int i = 0;
    while(i<n){
        c = a + b;
        a = b;
        b = c;
        i ++;
    }
    return c;
}
