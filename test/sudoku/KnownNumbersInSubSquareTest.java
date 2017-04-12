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

    @Test
    public void a3x3PuzzleHasNoSubSquares() {

        puzzle = new int[][] {{1, 2, 3},
                              {2, 3, 1},
                              {3, 1, 2}};

        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 0, 0).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 0, 1).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 0, 2).isEmpty());

        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 1, 0).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 1, 1).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 1, 2).isEmpty());

        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 2, 0).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 2, 1).isEmpty());
        assertTrue(sudoku.knownNumbersInSubSquare(puzzle, 2, 2).isEmpty());
    }

}
