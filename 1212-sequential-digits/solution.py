class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        s = "123456789"

        res = []

        for i in range(len(s) + 1):
            for j in range(i + 1, len(s) + 1):
                if int(s[i:j]) >= low and int(s[i:j]) <= high:
                    res.append(int(s[i:j]))

        res.sort() 
        
        return res
