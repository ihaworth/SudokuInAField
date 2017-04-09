package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {
        {
            int row = 0;
            int col = 0;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][1] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[row][1]);
                    return solve(puzzle);
                }

                if (puzzle[row][1] == 1) {
                    puzzle[row][col] = otherNumber(puzzle[row][1]);
                    return solve(puzzle);
                }

                if (puzzle[1][col] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[1][col]);
                    return solve(puzzle);
                }

                if (puzzle[1][col] == 1) {
                    puzzle[row][col] = otherNumber(puzzle[1][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 1;
            int col = 0;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][1] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[row][1]);
                    return solve(puzzle);
                }

                if (puzzle[row][1] == 1) {
                    puzzle[row][col] = otherNumber(puzzle[row][1]);
                    return solve(puzzle);
                }

                if (puzzle[0][col] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[0][col]);
                    return solve(puzzle);
                }

                if (puzzle[0][col] == 1) {
                    puzzle[row][col] = otherNumber(puzzle[0][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 1;
            int col = 1;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][0] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[row][0]);
                    return solve(puzzle);
                }

                if (puzzle[row][0] == 1) {
                    puzzle[row][col] = otherNumber(puzzle[row][0]);
                    return solve(puzzle);
                }

                if (puzzle[0][col] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[0][col]);
                    return solve(puzzle);
                }

                if (puzzle[0][col] == 1) {
                    puzzle[row][col] = otherNumber(puzzle[0][col]);
                    return solve(puzzle);
                }
            }
        }

        {
            int row = 0;
            int col = 1;
            if (puzzle[row][col] == 0) {
                if (puzzle[row][0] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[row][0]);
                    return solve(puzzle);
                }

                if (puzzle[row][0] == 1) {
                    puzzle[row][col] = otherNumber(puzzle[row][0]);
                    return solve(puzzle);
                }

                if (puzzle[1][col] == 2) {
                    puzzle[row][col] = otherNumber(puzzle[1][col]);
                    return solve(puzzle);
                }

                if (puzzle[1][col] == 1) {
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
