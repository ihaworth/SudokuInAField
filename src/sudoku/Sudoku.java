package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {
        {
            int row = 0;
            int col = 0;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][otherCol(col)] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][otherCol(col)]);
                    return solve(puzzle);
                }

                if (puzzle[otherRow(row)][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[otherRow(row)][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 1;
            int col = 0;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][otherCol(col)] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][otherCol(col)]);
                    return solve(puzzle);
                }

                if (puzzle[otherRow(row)][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[otherRow(row)][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 1;
            int col = 1;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][otherCol(col)] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][otherCol(col)]);
                    return solve(puzzle);
                }

                if (puzzle[otherRow(row)][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[otherRow(row)][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 0;
            int col = 1;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][otherCol(col)] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][otherCol(col)]);
                    return solve(puzzle);
                }

                if (puzzle[otherRow(row)][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[otherRow(row)][col]);
                    return solve(puzzle);
                }
            }
        }

        return puzzle;
    }

    private int otherRow(int row) {
        return (row == 1) ? 0 : 1;
    }

    private int otherCol(int col) {
        return (col == 1) ? 0 : 1;
    }

    private int otherNumber(int i) {
        return (i == 1) ? 2 : 1;
    }

}
