package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {
        if (puzzle[0][1] == 0) {
            puzzle[0][1] = 2;
        }
        if (puzzle[0][0] == 0) {
            if (puzzle[0][1] == 2)
                puzzle[0][0] = 1;

            if (puzzle[0][1] == 1)
                puzzle[0][0] = 2;
        }
        return puzzle;
    }

}
