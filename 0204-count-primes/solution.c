int countPrimes(int n) {
    bool prime[n + 1];
    for(int i = 0; i < n + 1; i++){
        prime[i] = false;
    }

    for(int i = 2; i < n; i++){
        if(prime[i]){
            continue;
        }
        if((long)i * i > n){
            continue;
        }
        for(int j = i * i; j < n; j += i){
            prime[j] = true;
        }
    }

    int count = 0;
    for(int i = 2; i < n; i++){
        if(!prime[i]){
            count++;
        }
    }

    return count;
}
