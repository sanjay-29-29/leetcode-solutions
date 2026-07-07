class Solution:
    def sumAndMultiply(self, n: int) -> int:
        curr = 0
        curr_sum = 0

        while n > 0:
            temp = n % 10
            print(temp)

            if temp != 0:
                curr = curr * 10 + temp
                curr_sum += temp

            n = n // 10

        # print(curr * curr_sum)

        return int(str(curr)[::-1]) * curr_sum
                
