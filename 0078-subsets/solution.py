from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        arr = [[]]  
        for i in range(len(nums)):
            for j in range(len(arr)):
                temp = arr[j] + [nums[i]]
                arr.append(temp)
        return arr
