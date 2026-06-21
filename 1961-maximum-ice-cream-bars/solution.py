class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        costs.sort()

        res = 0

        for i in costs:
            if coins >= i:
                res += 1
                coins -= i 

        return res
