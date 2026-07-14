class UF:
    def __init__(self, size):
        self.arr = [i for i in range(size)]
        self.size = [1] * size

    def find(self, val):
        parent = self.arr[val]
        
        if self.arr[parent] != parent:
            val = self.find(self.arr[parent]) 
            self.arr[parent] = val
            return val

        return parent

    def union(self, val1, val2):
        parent1 = self.find(val1)
        parent2 = self.find(val2)

        if parent1 == parent2:
            return

        if self.size[parent1] > self.size[parent2]:
            self.arr[parent2] = parent1
            self.size[parent1] += self.size[parent2]
        else:
            self.arr[parent1] = parent2
            self.size[parent2] += self.size[parent1]
        
class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        uf = UF(n)

        for i in range(len(nums) - 1):
            if abs(nums[i] - nums[i + 1]) <= maxDiff:
                uf.union(i, i+1)

        res = []

        for i in queries:
            if uf.find(i[0]) == uf.find(i[1]):
                res.append(True)
            else:
                res.append(False)

        return res
            
