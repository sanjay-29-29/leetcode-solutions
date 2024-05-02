class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rows, cols = len(matrix), len(matrix[0])
        marked = [[0] * cols for _ in range(rows)]  # Proper initialization
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0 and marked[i][j] != 1:
                    # Mark entire row and column
                    for k in range(cols):
                        if matrix[i][k] != 0:
                            matrix[i][k] = 0
                            marked[i][k] = 1
                    for k in range(rows):
                        if matrix[k][j] != 0:
                            matrix[k][j] = 0
                            marked[k][j] = 1

