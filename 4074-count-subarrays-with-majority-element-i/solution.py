class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        res = 0

        for i in range(len(nums)):
            count = 0
    
            for j in range(i, len(nums)):
                count += 1 if nums[j] == target else -1
                
                if count > 0:
                    res += 1

        return res


