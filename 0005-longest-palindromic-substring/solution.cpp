#include <string>

class Solution {
public:
    std::string longestPalindrome(std::string str) {
        int n = str.size();
        if (n == 0) {
            return "";
        }

        int start = 0, maxLength = 1;
        bool table[1000][1000] = {false}; // Initialize a 2D table for dynamic programming

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (str[i] == str[i + 1]) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for palindromes of length 3 or more
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;

                // Check if the substring is a palindrome
                if (table[i + 1][j - 1] && str[i] == str[j]) {
                    table[i][j] = true;

                    // Update the start and maxLength if a longer palindrome is found
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        // Extract the longest palindrome substring
        return str.substr(start, maxLength);
    }
};

