class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        arr_clone = list(set(arr.copy()))
        arr_clone.sort()

        i = 1
        freq_map = {}

        for val in arr_clone:
            freq_map[val] = i
            i += 1

        print(freq_map)

        for j in range(len(arr)):
            arr[j] = freq_map[arr[j]]

        return arr
