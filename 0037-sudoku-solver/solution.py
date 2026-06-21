class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row_set: list[set] = []
        col_set: list[set] = []
        grid_set: list[set] = []

        for i in range(9):
            row_set.append(set())
            col_set.append(set())
            grid_set.append(set())

        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    row_set[i].add(int(board[i][j]))
                    col_set[j].add(int(board[i][j]))
                    grid_set[int(i / 3) * 3 + int(j / 3)].add(int(board[i][j]))
                    # print(int(i / 3) * 3, int(j / 3), board[i][j])

        # for i in range(9):
        #     print(grid_set[i])

        self.soduku_solver(board, (0, 0), row_set, col_set, grid_set)

    def soduku_solver(
        self, 
        board: list[list[str]], 
        pos: tuple[int, int], 
        row_set: list[set[int]],
        col_set: list[set[int]],
        grid_set: list[set[int]]
    ) -> bool:
    
        if pos[0] >= 9:
            return True

        if pos[1] >= 9:
            return self.soduku_solver(board, (pos[0] + 1, 0), row_set, col_set, grid_set)

        if board[pos[0]][pos[1]] != ".":
            return self.soduku_solver(board, (pos[0], pos[1] + 1), row_set, col_set, grid_set)

        for i in range(1, 10):
            if i not in row_set[pos[0]] and i not in col_set[pos[1]] and i not in grid_set[int(pos[0] / 3) * 3 + int(pos[1] / 3)]:
                row_set[pos[0]].add(i)
                col_set[pos[1]].add(i)
                grid_set[int(pos[0] / 3) * 3 + int(pos[1] / 3)].add(i)
                board[pos[0]][pos[1]] = str(i)

                if self.soduku_solver(board, (pos[0], pos[1] + 1), row_set, col_set, grid_set):
                    return True

                else:
                    row_set[pos[0]].remove(i)
                    col_set[pos[1]].remove(i)
                    grid_set[int(pos[0] / 3) * 3 + int(pos[1] / 3)].remove(i)
                    board[pos[0]][pos[1]] = "."

        return False
