package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {

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
