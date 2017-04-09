package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {
        {
            int row = 0;
            int col = 0;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][1] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][1]);
                    return solve(puzzle);
                }

                if (puzzle[1][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[1][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 1;
            int col = 0;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][1] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][1]);
                    return solve(puzzle);
                }

                if (puzzle[0][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[0][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 1;
            int col = 1;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][0] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][0]);
                    return solve(puzzle);
                }

                if (puzzle[0][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[0][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 0;
            int col = 1;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][0] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[row][0]);
                    return solve(puzzle);
                }

                if (puzzle[1][col] != 0) {
                    puzzle[row][col] = otherNumber(puzzle[1][col]);
                    return solve(puzzle);
                }
            }
        }

        return puzzle;
    }

    private int otherNumber(int i) {
        return (i == 1) ? 2 : 1;
    }

}
