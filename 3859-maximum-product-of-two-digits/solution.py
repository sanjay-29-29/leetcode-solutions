class Solution:
    def maxProduct(self, n: int) -> int:
        l = list(str(n))
        s = sorted(l)

        return int(s[len(s) - 1]) * int(s[len(s) - 2])
