package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {
        if (puzzle[0][0] ==0) {
            puzzle[0][0] = 1;
        }
        return puzzle;
    }

}
