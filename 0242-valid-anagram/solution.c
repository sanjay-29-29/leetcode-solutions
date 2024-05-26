#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int count(char *word, char *unique, int *count_u) {
    int n = strlen(word);
    int size = 0;

    for (int i = 0; i < n; i++) {
        int flag = 0;
        for (int j = 0; j < size; j++) {
            if (word[i] == unique[j]) {
                flag = 1;
                count_u[j]++;
                break;
            }
        }
        if (!flag) {
            unique[size] = word[i];
            count_u[size] = 1;
            size++;
        }
    }

    return size;
}

bool isAnagram(char* s, char* t) {
    if(strlen(s) != strlen(t)){
        return false;
    }

    int* count_s = (int*)malloc(strlen(s) * sizeof(int));
    char* word_s = (char*)malloc(strlen(s) * sizeof(char));

    int* count_t = (int*)malloc(strlen(t) * sizeof(int));
    char* word_t = (char*)malloc(strlen(t) * sizeof(char));

    int len1 = count(s, word_s, count_s);
    int len2 = count(t, word_t, count_t);

    bool result = true;

    if (len1 != len2) {
        result = false;
    } else {
        for(int i = 0; i < len1; i++){
            int j;
            for(j = 0; j < len2; j++){
                if(word_s[i] == word_t[j] && count_s[i] == count_t[j]){
                    break;
                }
            }
            if(j == len2){
                result = false;
                break;
            }
        }
    }

    free(count_s);
    free(word_s);
    free(count_t);
    free(word_t);

    return result;
}

