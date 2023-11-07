from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merged = sorted(nums1 + nums2)
        n = len(merged)
        if n % 2 == 0:
            middle1 = merged[n // 2 - 1]
            middle2 = merged[n // 2]
            return (middle1 + middle2) / 2.0
        else:
            return float(merged[n // 2])

