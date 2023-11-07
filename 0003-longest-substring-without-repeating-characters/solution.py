class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen_chars = {}
        max_length = 0
        start = 0

        for end in range(len(s)):
            if s[end] in seen_chars and seen_chars[s[end]] >= start:
                start = seen_chars[s[end]] + 1
            seen_chars[s[end]] = end
            max_length = max(max_length, end - start + 1)

        return max_length
