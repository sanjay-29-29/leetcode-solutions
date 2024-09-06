int largestAltitude(int* gain, int gainSize) {
    int current = 0;
    int max = 0;
    for(int i=0;i<gainSize;i++){
        current = current + gain[i];
        if(current>max){
            max = current;
        }
    }
    return max;
}
