class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        char_map = {}
        word_char = {
            "b": 1,
            "a": 1,
            "l": 2,
            "o": 2,
            "n": 1
        }

        for i in text:
            val = char_map.get(i, 0)
            char_map[i] = val + 1

        res = 999999

        for key, val in word_char.items():
            res = min(res, char_map.get(key, 0) / val)


        return int(res)
