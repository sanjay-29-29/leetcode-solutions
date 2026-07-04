from collections import deque

class UnionFind:
    def __init__(self, size):
        self.arr = [0] * size
        self.rank = [1] * size

        for i in range(size):
            self.arr[i] = i

    def union(self, ele1, ele2):
        ele1_parent = self.find(ele1)
        ele2_parent = self.find(ele2)

        if ele1_parent == ele2_parent:
            return

        if self.rank[ele1_parent] > self.rank[ele2_parent]:
            self.rank[ele1_parent] += self.rank[ele2_parent]
            self.arr[ele2_parent] = ele1_parent
        else:
            self.rank[ele2_parent] += self.rank[ele1_parent]
            self.arr[ele1_parent] = ele2_parent

    def find(self, child):
        if self.arr[child] != child:
            self.arr[child] = self.find(self.arr[child])

        return self.arr[child]

class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        uf = UnionFind(n + 1)
        adj_map = {} 

        for x, y, z in roads:
            # adj_map.setdefault(x, []).append((y, z))
            uf.union(x, y)

        rep = uf.find(1)
        # print(rep)
        res = 999999

        for x, y, z in roads:
            if uf.find(x) == rep and uf.find(y) == rep:
                # print('hello')
                res = min(res, z)
            # else:
            #     print(uf.find(x))  
            #     print(uf.find(y))

        return res


        # queue = deque([1])
        # visited = set()

        # while len(queue) > 0:
        #     ele = queue.popleft()

        #     if ele in visited:
        #         continue

        #     for c in adj_map.get(ele, []):
        #         queue.append(c[0])
            
        # return 0
