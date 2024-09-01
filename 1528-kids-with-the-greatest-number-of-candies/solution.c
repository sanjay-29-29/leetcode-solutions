/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool checkMax(int *candies, int candiesSize, int extracandies, int currentIndex){
    int max = candies[currentIndex] + extracandies;
    for(int i=0;i<candiesSize;i++){
        if(i == currentIndex){
            continue;
        }
        if(candies[i]>max){
            return false;
        }
    }
    return true;
}
bool* kidsWithCandies(int* candies, int candiesSize, int extraCandies, int* returnSize) {
    bool* list = (bool*)malloc(candiesSize * sizeof(bool));
    for(int i=0;i<candiesSize;i++){
        list[i] = checkMax(candies,candiesSize,extraCandies,i);
    }

    *returnSize = candiesSize;
    return list;
}

