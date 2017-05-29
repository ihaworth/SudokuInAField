package sudoku;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumbersInSubSquareTest {

    private final Sudoku sudoku = new Sudoku();

    private int[][] puzzle;

    @Test
    public void a2x2PuzzleHasNoSubSquares() {

        puzzle = new int[][] {{1, 2},
                {2, 1}};

        assertTrue(sudoku.numbersInSubSquare(puzzle, 0, 0).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 0, 1).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 1, 0).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 1, 1).isEmpty());
    }

    @Test
    public void a3x3PuzzleHasNoSubSquares() {

        puzzle = new int[][] {{1, 2, 3},
                              {2, 3, 1},
                              {3, 1, 2}};

        assertTrue(sudoku.numbersInSubSquare(puzzle, 0, 0).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 0, 1).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 0, 2).isEmpty());

        assertTrue(sudoku.numbersInSubSquare(puzzle, 1, 0).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 1, 1).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 1, 2).isEmpty());

        assertTrue(sudoku.numbersInSubSquare(puzzle, 2, 0).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 2, 1).isEmpty());
        assertTrue(sudoku.numbersInSubSquare(puzzle, 2, 2).isEmpty());
    }

    @Test
    public void a4x4PuzzleHasATopLeftSubSquare() {

        puzzle = new int[][] {{3, 2, 0, 0},
                              {1, 4, 0, 0},
                              {0, 0, 0, 0},
                              {0, 0, 0, 0}};

        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 0), set(1, 2, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 1), set(1, 2, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 0), set(1, 2, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 1), set(1, 2, 3, 4));
    }

    @Test
    public void a4x4PuzzleHasATopLeftSubSquareThatMyNotBeComplete() {

        puzzle = new int[][] {{3, 0, 0, 0},
                              {0, 4, 0, 0},
                              {0, 0, 0, 0},
                              {0, 0, 0, 0}};

        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 0), set(0, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 1), set(0, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 0), set(0, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 1), set(0, 3, 4));
    }

    @Test
    public void a4x4PuzzleHasATopLeftSubSquareThatCanBeEmpty() {

        puzzle = new int[][] {{0, 0, 3, 2},
                              {0, 0, 1, 4},
                              {0, 0, 0, 0},
                              {0, 0, 0, 0}};

        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 0), set(0));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 1), set(0));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 0), set(0));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 1), set(0));
    }

    @Test
    public void a4x4PuzzleHasATopRightSubSquare() {

        puzzle = new int[][] {{0, 0, 3, 2},
                              {0, 0, 1, 4},
                              {0, 0, 0, 0},
                              {0, 0, 0, 0}};

        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 2), set(1, 2, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 0, 3), set(1, 2, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 2), set(1, 2, 3, 4));
        assertEquals(sudoku.numbersInSubSquare(puzzle, 1, 3), set(1, 2, 3, 4));
    }

    private Set<Integer> set(Integer... ints) {
        return new HashSet<>(Arrays.asList(ints));
    }

}
