package sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnownNumbersInSubSquareTest {

    private final Sudoku sudoku = new Sudoku();

    private int[][] puzzle;

    @Test
    public void a2x2PuzzleHasNoSubSquares() {

        puzzle = new int[][] {{1, 2},
                              {2, 1}};

        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 0, 0).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 0, 1).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 1, 0).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 1, 1).isEmpty());
    }

}
